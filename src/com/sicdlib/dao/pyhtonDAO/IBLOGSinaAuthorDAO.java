package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BlogSinaAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGSinaAuthorDAO {
    Boolean saveBLOGSinaAuthor(BlogSinaAuthorEntity blogSinaAuthor);

    List<BlogSinaAuthorEntity> getBlogSinaAuthor();
}
