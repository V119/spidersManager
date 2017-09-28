package com.sicdlib.service.hbaseService;

import java.util.List;

public interface IPostService {
    //根据表名获取文章总数
    int getAllPostNum(String tableName);
    //查询对应表的所有文章集合
    List<Object[]> getPostList(String tableName, String condition,String conditionValue);
    //查询对应作者ID，文章ID的作者信息
    Object getPostInfo(String condition, String tableName,String conditionValue);

    List<Object[]> getMoePostList(String tableName, String newsEditor);
    Object getMoePostInfo(String newsTitle, String tableName);
}
