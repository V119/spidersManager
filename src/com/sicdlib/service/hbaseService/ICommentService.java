package com.sicdlib.service.hbaseService;

import java.util.List;

public interface ICommentService {
    List<Object[]> getCommentList(String tableName, String condition, String conditionValue);
}
