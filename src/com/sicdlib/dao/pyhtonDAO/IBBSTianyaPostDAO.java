package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsTianyaPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSTianyaPostDAO {
    Boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost);
    BbsTianyaPostEntity getBbsTianyaPost(String id);

    List<BbsTianyaPostEntity> getbbstianyaPost(String authorID);
}
