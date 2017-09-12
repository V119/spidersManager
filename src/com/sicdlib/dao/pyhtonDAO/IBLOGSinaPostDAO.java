package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BlogSinaPostEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGSinaPostDAO {
    Boolean saveBLOGSinaPost(BlogSinaPostEntity blogSinaPost);
    BlogSinaPostEntity getBlogSinaPost(String id);
}
