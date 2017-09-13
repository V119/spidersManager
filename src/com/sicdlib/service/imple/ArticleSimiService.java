package com.sicdlib.service.imple;

import com.sicdlib.dao.*;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.IArticleSimiService;
import com.sicdlib.util.KeyWordsUtil.Segmentation;
import com.sicdlib.util.SimilarityUtil.CosSimilarity;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/5.
 */
@Service("articleSimiService")
public class ArticleSimiService implements IArticleSimiService {
    @Autowired
    @Qualifier("eventArticleDAO")
    private IEventArticleDAO eventArticleDAO;

    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Autowired
    @Qualifier("articleSimiDAO")
    private IArticleSimiDAO articleSimiDAO;

    /**
     * 方法：计算某个事件下所有文章的相似度
     */
    @Override
    public void setEventArticleSimi(String eventID) {
//        List<String> stops = stopWordsDAO.getAllStopWords();

        List<TbTableEntity> tableList = tableDAO.getTableByEventID(eventID);
        List<String> idList = new ArrayList<>();
        List<List<String>> wordsList = new ArrayList<>();

        for (TbTableEntity table : tableList) {
            List<String[]> contents = tableDAO.getArticleIdAndContent(eventID, table.getId(), table.getTableName());
            for (Object[] content : contents) {
                //将文章ID加入队列
                idList.add((String) content[0]);

                //分词，并将分词后的结果加入队列，暂不去除停用词，看效果
                Segmentation seg = new Segmentation((String) content[1]);
                List<String> words = seg.getWordsList();

                wordsList.add(words);
            }
        }
        //计算两两之间的相似度
        List<TbArticleSimilarityEntity> simiEntityList = new ArrayList<>();
        Map<String, TbEventArticleEntity> eventMap = new HashMap<>();
        eventMap.put(idList.get(0),eventArticleDAO.getEventArticleEntity(idList.get(0)));

//        double simiSum = 0;
//        int num = 0;

        for (int i = 1; i < wordsList.size(); i++) {
            for (int j = 0; j < i; j++) {
                double simi = CosSimilarity.calculate(wordsList.get(i), wordsList.get(j));

//                num++;
//                simiSum += simi;

                TbEventArticleEntity eventArticleA = eventArticleDAO.getEventArticleEntity(idList.get(i));
                eventMap.put(idList.get(i),eventArticleA);

                TbEventArticleEntity eventArticleB = eventMap.get(idList.get(j));

                TbArticleSimilarityEntity simiEntity = new TbArticleSimilarityEntity();
                simiEntity.setId(UUIDUtil.getUUID());
                simiEntity.setArticleA(eventArticleA);
                simiEntity.setArticleB(eventArticleB);
                simiEntity.setSimilarity(simi);

                simiEntityList.add(simiEntity);
            }
        }

//        double avg = simiSum / num;
//        //计算标准差
//        final double[] devSum = {0};
//        simiEntityList.parallelStream().forEach(simiEntity-> devSum[0] += (simiEntity.getSimilarity() - avg) * (simiEntity.getSimilarity() - avg));
//
//        double standDev = Math.sqrt(devSum[0] / num);
//
//        //归一化
//        simiEntityList.forEach(simiEntity-> simiEntity.setSimilarity((simiEntity.getSimilarity() - avg) / standDev));


        articleSimiDAO.batchSaveSimiEntity(simiEntityList);

    }
}
