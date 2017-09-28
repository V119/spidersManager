package com.sicdlib.service.hbaseService.imple;

import com.sicdlib.dao.hbaseDAO.IPostDAO;
import com.sicdlib.service.hbaseService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostService implements IPostService {

    @Autowired
    @Qualifier("postDAO")
    private IPostDAO postDAO;
    @Override
    public int getAllPostNum(String tableName) {
        return postDAO.getAllPostNum(tableName);
    }

    @Override
    public List<Object[]> getPostList(String tableName,String condition,String conditionValue) {
        return postDAO.getPostList(tableName,condition,conditionValue);
    }

    @Override
    public Object getPostInfo( String condition, String tableName,String conditionValue) {
        return postDAO.getPostInfo(condition,tableName,conditionValue);
    }

    @Override
    public List<Object[]> getMoePostList(String tableName, String newsEditor) {
        return postDAO.getMoePostList(tableName,newsEditor);
    }

    @Override
    public Object getMoePostInfo(String newsTitle, String tableName) {
        return postDAO.getMoePostInfo(newsTitle,tableName);
    }
}
