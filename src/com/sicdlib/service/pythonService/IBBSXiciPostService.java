package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsXiciPostEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSXiciPostService {
    //更新或新增西祠
    boolean saveBBSXiciPost(BbsXiciPostEntity bbsXiciPost);
    BbsXiciPostEntity getBbsXiciPost(String id);
}
