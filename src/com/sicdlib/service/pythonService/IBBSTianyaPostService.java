package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsTianyaPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSTianyaPostService {
    //更新或新增天涯
    boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost);
    BbsTianyaPostEntity getBbsTianyaPost(String id);

    List<BbsTianyaPostEntity> getbbstianyaPost(String authorID);
}
