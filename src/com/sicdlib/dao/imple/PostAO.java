package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IPostDAO;
import com.sicdlib.dao.ITableColumnDAO;
import com.sicdlib.util.PageUtil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDAO")
public class PostAO implements IPostDAO{

    @Autowired
    @Qualifier("tableColumnDAO")
    private ITableColumnDAO tableColumnDAO;

    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public int getAllPostNum(String tableName) {
        return 0;
    }

    @Override
    public List<Object[]> getPostList(String tableName, Page page) {
        return null;
    }

    @Override
    public Object[] getPostInfo(String authorId, String postId, String tableName) {
        return new Object[0];
    }
}
