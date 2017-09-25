package com.sicdlib.service;

import com.sicdlib.util.HBaseUtil.HBPage;
import com.sicdlib.util.PageUtil.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/15.
 */
public interface IAuthorService {
    void setAuthorAttributes(String eventID);
    Map<String, Map> getAuthorInfluenceAndActiveness(String eventID);

    //write by lyan
    //根据表名获取作者总数
    int getAllAuthorNum(String tableName);
    //查询对应表的所有作者集合
    List<Object[]> getAuthorList(String tableName,HBPage page);
    //查询对应作者ID的作者信息
    Object getAuthorInfo(String authorId,String tableName);
}
