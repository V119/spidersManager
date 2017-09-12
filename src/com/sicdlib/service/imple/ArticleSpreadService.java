package com.sicdlib.service.imple;

import com.sicdlib.dao.IArticleSimiDAO;
import com.sicdlib.dao.IEventArticleDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dao.IWebsiteDAO;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import com.sicdlib.service.IArticleSpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by YH on 2017/6/6.
 */
@Service("articleSpreadService")
public class ArticleSpreadService implements IArticleSpreadService {
    @Autowired
    @Qualifier("articleSimiDAO")
    private IArticleSimiDAO articleSimiDAO;

    @Autowired
    @Qualifier("eventArticleDAO")
    private IEventArticleDAO eventArticleDAO;

    @Autowired
    @Qualifier("websiteDAO")
    private IWebsiteDAO websiteDAO;

    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Override
    public Map<String, List> getNodeAndEdgeAttributes(String eventID) {
        int sliceNum = 10; //将相似度分为10份
        double sliceSize = 1.0 / sliceNum;
//        double simi = 0.35;
        List<TbArticleSimilarityEntity> articleSimiList = articleSimiDAO.getSimiArticleEntityList(eventID);

        //存放在不同相似都情况下每个节点的大小
        Map<String, Vector<Integer>> articleSimiNumMap = new ConcurrentHashMap<>();

        Map<String, String> articleTitleMap = new ConcurrentHashMap<>();
        Map<String, String> articleWebsite = new ConcurrentHashMap<>();
        Map<String, String> tableNameMap = new ConcurrentHashMap<>();

        Vector<Vector<Map<String, Object>>> edgeList = new Vector<>();
        for(int i = 0; i <= sliceNum; i++) {
            AtomicReference<Vector<Map<String, Object>>> vector = new AtomicReference<>(new Vector<>());
            edgeList.add(vector.get());
        }

        articleSimiList
//                .parallelStream()
                .forEach(articleSimi->{
                    String articleAID = articleSimi.getArticleA().getSourceArticleId();
                    String articleBID = articleSimi.getArticleB().getSourceArticleId();

            //初始化节点相关节点的个数
            if (!articleSimiNumMap.containsKey(articleAID)) {
                //获取文章标题
                String articleATitle = eventArticleDAO.getArticleTitle(
                        articleSimi.getArticleA().getTable().getId(),
                        articleAID
                );

                //初始化每个节点在不同相似度下节点的大小,初始化为0
                Vector<Integer> nodeSizeList = new Vector<>();
                for (int i = 0; i <= sliceNum; i++) {
                    nodeSizeList.add(0);
                }
                articleSimiNumMap.put(articleAID, nodeSizeList);

                articleTitleMap.put(articleAID, articleATitle);

                //来源网站
                String sourceWebsite = websiteDAO.getWebsiteByTableID(
                        articleSimi.getArticleA().getTable().getId()).getWebsiteName();
                articleWebsite.put(articleAID, sourceWebsite);

                //文章来源表
                tableNameMap.put(articleAID, articleSimi.getArticleA().getTable().getTableName());
            }
            if(!articleSimiNumMap.containsKey(articleBID)) {
                //获取文章标题
                String articleBTitle = eventArticleDAO.getArticleTitle(
                        articleSimi.getArticleB().getTable().getId(),
                        articleBID
                );

                //初始化每个节点在不同相似度下节点的大小,初始化为0
                Vector<Integer> nodeSizeList = new Vector<>();
                for (int i = 0; i <= sliceNum; i++) {
                    nodeSizeList.add(0);
                }
                articleSimiNumMap.put(articleBID, nodeSizeList);

                //文章标题
                articleTitleMap.put(articleBID, articleBTitle);

                //来源网站
                String sourceWebsite = websiteDAO.getWebsiteByTableID(
                        articleSimi.getArticleB().getTable().getId()).getWebsiteName();
                articleWebsite.put(articleBID, sourceWebsite);

                //文章来源表
                tableNameMap.put(articleBID, articleSimi.getArticleB().getTable().getTableName());

            }

            //时间早的作为source，晚的为target
            //如果相似度高于simi，连接两个节点


            String edgeSource = "";
            String edgeTarget = "";
            if(articleTitleMap.get(articleAID).compareTo(articleTitleMap.get(articleBID)) > 0) {
                edgeSource = articleBID;
                edgeTarget = articleAID;
            } else {
                edgeSource = articleAID;
                edgeTarget = articleBID;
            }

            //对相应的相似度阈值+1
            Vector<Integer> simiAList = articleSimiNumMap.get(articleAID);
            Vector<Integer> simiBList = articleSimiNumMap.get(articleBID);

            //循环，加入相应的阈值数组
            for (int i = 0; i <= (int)(articleSimi.getSimilarity() / sliceSize); i++) {
                AtomicInteger countA = new AtomicInteger(simiAList.get(i));
                AtomicInteger countB = new AtomicInteger(simiBList.get(i));

                simiAList.set(i, countA.incrementAndGet());
                simiBList.set(i, countB.incrementAndGet());

                Map<String, Object> edgeMap = new HashMap<>();
                edgeMap.put("source", edgeSource);
                edgeMap.put("target", edgeTarget);

                Vector<Map<String, Object>> vector = edgeList.get(i);
                vector.add(edgeMap);
                edgeList.set(i, vector);
            }

            articleSimiNumMap.put(articleAID, simiAList);
            articleSimiNumMap.put(articleBID, simiBList);
        });

        List<Map> nodeList = new ArrayList<>();
        articleTitleMap.forEach((articleID, articleTitle)->{
            Map<String, Object> element = new HashMap<>();
            element.put("title", articleTitle.replaceAll("\\\\s*|\\t|\\r|\\n", ""));
            element.put("num", articleSimiNumMap.get(articleID));
            element.put("website", articleWebsite.get(articleID));
            element.put("id", articleID);
            element.put("table", tableNameMap.get(articleID));

            nodeList.add(element);
        });

        Map<String, List> result = new HashMap<>();
        result.put("nodes", nodeList);
        result.put("edges", edgeList);

        return result;
    }

    @Override
    public String getArticleContent(String articleID, String tableName) {
        return tableDAO.getArticleContent(articleID, tableName);
    }
}
