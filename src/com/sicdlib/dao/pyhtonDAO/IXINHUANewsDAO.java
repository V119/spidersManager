package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.XinhuaNewsEntity;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
public interface IXINHUANewsDAO {
    Boolean saveXINHUANews(XinhuaNewsEntity xinhuaNews);
    List<XinhuaNewsEntity> getAllXinHuaNews();
    XinhuaNewsEntity getAllXinHuaNewsByArticleID(String id);

    List<XinhuaNewsEntity> getBbsXinhuaAuthor();
}
