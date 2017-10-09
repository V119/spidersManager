package com.sicdlib.dao;

import java.util.List;
import java.util.Map;

public interface ICalendarDao {
//    public List<String>
    List getThead(String tablename);
    List getTbody(String tablename);
    Map getOrder(String tableName, String columnName);
}
