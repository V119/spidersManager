package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsSohuPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSSohuPostService {
    //更新或新增搜狐
    boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost);
    BbsSohuPostEntity getBbsSohuPost(String id);

    List<BbsSohuPostEntity> getbbssohuPost(String authorID);
}
