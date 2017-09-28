package com.sicdlib.service.imple;

import com.sicdlib.dao.ITableColumnDAO;
import com.sicdlib.dao.ITableCommentDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dao.hbaseDAO.IAuthorDAO;
import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.service.ITableService;
import com.sicdlib.util.TableUtil.ArticleAuthorTableMapping;
import com.sicdlib.util.TableUtil.ArticleCommentTableMapping;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("tableService")
public class TableService implements ITableService{
    @Autowired
    @Qualifier("tableDAO")
    private ITableDAO tableDAO;

    @Autowired
    @Qualifier("authorDAO")
    private IAuthorDAO authorDAO;

    @Autowired
    @Qualifier("tableColumnDAO")
    private ITableColumnDAO tableColumnDAO;

    @Autowired
    @Qualifier("tableCommentDAO")
    private ITableCommentDAO tableCommentDAO;

    @Override
    public Boolean saveOrUpdateTable(TbTableEntity table) {
        if (table.getId() == null){
            String uuid = UUIDUtil.getUUID();
            table.setId(uuid);
        }
        return tableDAO.saveOrUpdateTable(table);
    }

    @Override
    public TbTableEntity getTable(String name) {
        return tableDAO.getTable(name);
    }

    @Override
    public Map<String, Integer> getCommentNumByTableName(String eventname) {
        return  tableDAO.getCommentNumByTableName(eventname);
    }


    public void setAuthorAttributes(String eventID) throws Exception {
        //存储不同网站信息的Map
        //Map<String, List<Object[]>> authorMap = new HashMap<>();

        //获取事件下记录作者的网站名，如果没有单独的作者表，则返回post表
        List<TbTableEntity> tableList = tableDAO.getTableByEventID(eventID);
        for (TbTableEntity articleTable: tableList) {
            String articleTableName = articleTable.getTableName();
            String authorTableName = ArticleAuthorTableMapping.getAuthorTable(articleTableName);
            String tableID = articleTable.getId();

            //是否存在相应的评论表
            //如果存在评论表，查看评论表中是否存在用户id
            String commentTableName = ArticleCommentTableMapping.getCommentTable(articleTableName);
            if(!tableColumnDAO.isExistTable("socialmind", commentTableName)) {
                commentTableName = null;
            }
            boolean commentIsExistAuthorID = false;
            if(commentTableName != null) {
                commentIsExistAuthorID = tableColumnDAO.isExistColumn(commentTableName, "author_id");
            }

            List<Object[]> authorInfoList;
            //如果作者表和文章表是同一张表
            if (authorTableName.equals(articleTableName)) {
                authorInfoList = authorDAO.getAuthorNameWithNonePost(eventID, tableID, articleTableName);

                //通过用户ID获取用户发布文章的浏览量、发布文章数、和文章回复数
                for (Object[] authorInfo: authorInfoList) {
                    TbAuthorEntity authorEntity = new TbAuthorEntity();
                    TbEventAuthorMappingEntity eventMapping = new TbEventAuthorMappingEntity();

                    String authorId = (String) authorInfo[0];
                    String authorName = (String) authorInfo[1];
                    BigInteger fansNum = (BigInteger) authorInfo[2];

                    authorEntity.setId(UUIDUtil.getUUID());
                    authorEntity.setSourceAuthorId(authorId);
                    authorEntity.setSourceAuthorName(authorName);
                    authorEntity.setAuthorFansNum(fansNum);

                    Object[] authorNumInfo = authorDAO.getAuthorReadArticleReplyNumInPostTable(authorName, articleTableName);
                    BigInteger postSum = (BigInteger) authorNumInfo[0];
                    BigDecimal commentNum = (BigDecimal) authorNumInfo[1];
                    BigDecimal readNum = (BigDecimal) authorNumInfo[2];

                    authorEntity.setAuthorPostNum(postSum.intValue());
                    authorEntity.setPostReplyNum(commentNum.intValue());
                    authorEntity.setAuthorPostReadNum(readNum.longValue());

                    //查找用户参与的评论数并计算发布者的参与度
                    int pCommentNum = 0;

                    if(commentTableName != null) {
                        if(commentIsExistAuthorID) {
                            pCommentNum = tableCommentDAO.participantCommentNumById(commentTableName,authorId);

                        }
                        else {
                            pCommentNum = tableCommentDAO.participantCommentNumByName(commentTableName,authorName);
                        }
                    }
                    authorEntity.setParticipateCommentNum(pCommentNum);

                    //计算参与度
                    double activeness = this.calActiveness(postSum.intValue(), pCommentNum);
                    authorEntity.setActiveness(activeness);

                    authorEntity.setAuthorInfluence(
                            this.calInfluence(postSum.intValue(), commentNum.intValue(),
                                    readNum.longValue(), fansNum.intValue()));

                    authorEntity.setTable(articleTable);
                    eventMapping.setId(UUIDUtil.getUUID());
                    eventMapping.setAuthor(authorEntity);

                    authorDAO.saveAuthorEntity(authorEntity);
                    authorDAO.saveEventAuthorMapping(eventMapping, eventID);
                }
            } else { //如果不是同一张表
                authorInfoList = authorDAO.getAuthorIdAndNameAndFansNumWithPost(eventID, tableID, articleTableName, authorTableName);

                for (Object[] authorInfo: authorInfoList) {
                    TbAuthorEntity authorEntity = new TbAuthorEntity();
                    TbEventAuthorMappingEntity eventMapping = new TbEventAuthorMappingEntity();

                    String authorId = (String) authorInfo[0];
                    String sourceAuthorId = (String) authorInfo[1];
                    String authorName = (String) authorInfo[2];
                    BigInteger fansNum = (BigInteger) authorInfo[3];

                    authorEntity.setId(UUIDUtil.getUUID());
                    authorEntity.setSourceAuthorId(authorId);
                    authorEntity.setSourceAuthorName(authorName);
                    authorEntity.setAuthorFansNum(fansNum);

                    Object[] authorNumInfo = authorDAO.getAuthorReadArticleReplyNumInAuthorTable(sourceAuthorId, articleTableName);
                    BigInteger postSum = (BigInteger) authorNumInfo[0];
                    BigDecimal commentNum = (BigDecimal) authorNumInfo[1];
                    BigDecimal readNum = (BigDecimal) authorNumInfo[2];

                    authorEntity.setAuthorPostNum(postSum.intValue());
                    authorEntity.setPostReplyNum(commentNum.intValue());
                    authorEntity.setAuthorPostReadNum(readNum.longValue());

                    //查找用户参与的评论数并计算发布者的参与度
                    int pCommentNum = 0;

                    if(commentTableName != null) {
                        if(commentIsExistAuthorID) {
                            pCommentNum = tableCommentDAO.participantCommentNumById(commentTableName,authorId);
                        }
                        else {
                            pCommentNum = tableCommentDAO.participantCommentNumByName(commentTableName,authorName);
                        }
                    }
                    authorEntity.setParticipateCommentNum(pCommentNum);

                    //计算参与度
                    double activeness = this.calActiveness(postSum.intValue(), pCommentNum);
                    authorEntity.setActiveness(activeness);

                    //计算影响力
                    authorEntity.setAuthorInfluence(
                            this.calInfluence(postSum.intValue(), commentNum.intValue(),
                                    readNum.longValue(), fansNum.intValue()));

                    authorEntity.setTable(articleTable);
                    eventMapping.setId(UUIDUtil.getUUID());
                    eventMapping.setAuthor(authorEntity);
                    authorDAO.saveAuthorEntity(authorEntity);
                    authorDAO.saveEventAuthorMapping(eventMapping, eventID);
                }
            }
        }

    }

    @Override
    public List<String[]> getActivess(String eventID) {
        return null;
    }

    /**
     * 计算影响力，（发布者发布文章数+发布者发布文章的评论数+发布者发布文章的阅读数+粉丝数）/4
     * @param postNum 发布者发布文章数
     * @param replyNum 发布者发布文章的评论数
     * @param readNum 发布者发布文章的阅读数
     * @param fansNum 粉丝数
     * @return 影响力
     */
    private double calInfluence(int postNum, int replyNum, long readNum, int fansNum) {
        double influenceNum = (postNum + replyNum + readNum + fansNum) / 4;
        return influenceNum;
    }

    /**
     * 发布者活跃度，0.7 * 发表文章数 + 0.3 * 参与回复数
     * @param postNum 发表文章数
     * @param participateCommentNum 参与回复数
     * @return 发布者活跃度
     */
    private double calActiveness(int postNum, int participateCommentNum) {
        double result = 0.7 * postNum + 0.3 * participateCommentNum;
        return result;
    }
    /**
     *网民参与度，参与回复数/点击数
     * @param hitNum 点击数
     * @param participateCommentNum 参与回复数
     * @return 网民参与度
     */
    private double activeness(int hitNum, int participateCommentNum){
        double result = participateCommentNum / hitNum ;
        return result;
    }
}
