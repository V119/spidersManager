package com.sicdlib.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ICalendarService {
    //查询并返回数据库的字段头,传入参数为表的名字
    List getThead(String tablename);
    //查询并返回数据库的内容
    List getTbody(String tablename);
    //获得某列的值数量的排序
    Map getOrder(String tableName, String columnName);

    //update数据库的内容
    //public Boolean updateTable(String tablename,String titlename,String );

}
