package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.dto.entity.BbsMopPostEntity;

import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopPostDAO {
    Boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost);
    void batchNormalizeContent();
    BbsMopPostEntity getBbsMopPost(String id);

    List<BbsMopAuthorEntity> getbbsmopPost(String authorID);
}
