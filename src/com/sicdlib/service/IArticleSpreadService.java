package com.sicdlib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by YH on 2017/6/6.
 */
public interface IArticleSpreadService {
    /**
     * 获取文章的标题、相似都较高的文章数、所属网站
     * @param eventID
     * @return
     */
    Map<String, List> getNodeAndEdgeAttributes(String eventID);

    List<Map<String, Object>> getSNA(List<Map<String, Object>> nodes,List<List<Map<String, Object>>> edgesList);
    Map<Object, Object> getSNA1(List<Map<String, Object>> nodes,List<List<Map<String, Object>>> edgesList);

    Map<String, Object> getSNA2(List<Map<String, Object>> nodes,List<Map<String, Object>> edgesList);


    String getArticleContent(String articleID, String tableName);
}
