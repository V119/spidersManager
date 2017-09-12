package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BlogSinaPostEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGSinaPostService {
    public boolean saveBLOGSinaPost(BlogSinaPostEntity blogSinaPost);
    BlogSinaPostEntity getBlogSinaPost(String id);
}
