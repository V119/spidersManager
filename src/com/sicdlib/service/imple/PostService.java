package com.sicdlib.service.imple;

import com.sicdlib.dao.IPostDAO;
import com.sicdlib.service.IPostService;
import com.sicdlib.util.PageUtil.Page;
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
    public List<Object[]> getPostList(String tableName, Page page) {
        return postDAO.getPostList(tableName,page);
    }

    @Override
    public Object[] getPostInfo(String authorId, String postId, String tableName) {
        return postDAO.getPostInfo(authorId,postId,tableName);
    }
}
