package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BlogchinaAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGChinaAuthorService {
    //更新或新增博客中国
    boolean saveBLOGChinaAuthor(BlogchinaAuthorEntity blogchinaAuthor);

    List<BlogchinaAuthorEntity> getBlogChinaAuthor();
}
