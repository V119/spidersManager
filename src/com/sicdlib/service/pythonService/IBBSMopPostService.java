package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsMopPostEntity;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopPostService {
    //新增orgengxin猫扑社区文章
    public boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost);
    BbsMopPostEntity getBbsMopPost(String id);
}
