package com.sicdlib.dao.hbaseDAO;

import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;
import com.sicdlib.util.HBaseUtil.HBPage;

import java.util.List;

/**
 * Created by YH on 2017/6/16.
 */
public interface IAuthorDAO {
    List<Object[]> getAuthorIdAndNameAndFansNumWithPost(String eventID, String tableID, String postTableName, String authorTableName) throws Exception;
    List<Object[]> getAuthorNameWithNonePost(String eventID, String tableID, String articleTableName) throws Exception;

    Object[] getAuthorReadArticleReplyNumInAuthorTable(String authorID, String tableName);
    Object[] getAuthorReadArticleReplyNumInPostTable(String authorName, String tableName);

    void saveAuthorEntity(TbAuthorEntity authorEntity);
    void saveEventAuthorMapping(TbEventAuthorMappingEntity eventAuthor);
    void saveEventAuthorMapping(TbEventAuthorMappingEntity eventAuthor, String eventID);

    List<TbEventAuthorMappingEntity> getEventAuthorMappingByEventId(String eventID);
    //write by lyan
    //根据表名获取作者总数
    int getAllAuthorNum(String tableName);
    //查询对应表的所有作者集合
    /*List<Object[]> getAuthorList(String tableName,HBPage page,List<PageInfo> pageEntityList);*/
    List<Object[]> getAuthorList(String tableName,HBPage page);
    //查询对应作者ID的作者信息
    Object getAuthorInfo(String condition,String conditionValue, String tableName);
    List<Object[]> getMoeAuthorList(String tableName,HBPage page,String condition);


}
