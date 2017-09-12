package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BlogchinaBlogEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOGChinaBlogDAO {
    Boolean saveBLOGChinaBlog(BlogchinaBlogEntity blogchinaBlog);
    BlogchinaBlogEntity getBlogchinaBlog(String id);
}
