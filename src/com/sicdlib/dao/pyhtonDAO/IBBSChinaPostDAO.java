package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsChinaPostEntity;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaPostDAO {
    Boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost);
    BbsChinaPostEntity getBbsChinaPost(String id);
}
