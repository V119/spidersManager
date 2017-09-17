package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BlogchinaAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGChinaAuthorDAO {
    Boolean saveBLOGChinaAuthor(BlogchinaAuthorEntity blogchinaAuthor);

    List<BlogchinaAuthorEntity> getBlogChinaAuthor();
}
