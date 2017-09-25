package com.sicdlib.service;

import com.sicdlib.util.PageUtil.Page;

import java.util.List;

public interface IPostService {
    //根据表名获取文章总数
    int getAllPostNum(String tableName);
    //查询对应表的所有文章集合
    List<Object[]> getPostList(String tableName,String authorID);
    //查询对应作者ID，文章ID的作者信息
    Object getPostInfo( String postId, String tableName);
}
