package com.sicdlib.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ICalendarService {
    //查询并返回数据库的字段头,传入参数为表的名字
    List getThead(String tablename);
    //查询并返回数据库的内容
    List getTbody(String tablename);
    //update数据库的内容
    //public Boolean updateTable(String tablename,String titlename,String );
}
