package com.sicdlib.service.hbaseService.imple;

import com.sicdlib.dao.hbaseDAO.IPostDAO;
import com.sicdlib.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostService implements IPostService{

    @Autowired
    @Qualifier("postDAO")
    private IPostDAO postDAO;
    @Override
    public int getAllPostNum(String tableName) {
        return postDAO.getAllPostNum(tableName);
    }

    @Override
    public List<Object[]> getPostList(String tableName,String authorID) {
        return postDAO.getPostList(tableName,authorID);
    }

    @Override
    public Object getPostInfo( String postId, String tableName) {
        return postDAO.getPostInfo(postId,tableName);
    }
}
