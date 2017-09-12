package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BlogchinaBlogEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGChinaBlogService {
    public boolean saveBLOGChinaBlog(BlogchinaBlogEntity blogchinaBlog);
    BlogchinaBlogEntity getBlogchinaBlog(String id);
}
