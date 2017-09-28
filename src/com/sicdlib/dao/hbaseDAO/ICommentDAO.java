package com.sicdlib.dao.hbaseDAO;

import java.util.List;

public interface ICommentDAO {
    List<Object[]> getCommentList(String tableName, String condition,String conditionValue);
}
