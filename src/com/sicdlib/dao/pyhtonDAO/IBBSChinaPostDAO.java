package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsChinaPostEntity;

import java.util.List;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaPostDAO {
    Boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost);
    BbsChinaPostEntity getBbsChinaPost(String id);
    //根据作者ID获得所有的文章
    List<BbsChinaPostEntity> getbbsChinaPost(String authorID);
    //根据文章ID获得对应每一篇文章的详细内容
    BbsChinaPostEntity getBbsChinaPostInfoByID(String postID);
}
