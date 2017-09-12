package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsMopPostEntity;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopPostDAO {
    Boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost);
    void batchNormalizeContent();
    BbsMopPostEntity getBbsMopPost(String id);
}
