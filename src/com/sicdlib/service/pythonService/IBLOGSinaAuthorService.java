package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BlogSinaAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGSinaAuthorService {
    //更新或新增微博
    boolean saveBLOGSinaAuthor(BlogSinaAuthorEntity blogSinaAuthor);

    List<BlogSinaAuthorEntity> getBlogSinaAuthor();
}
