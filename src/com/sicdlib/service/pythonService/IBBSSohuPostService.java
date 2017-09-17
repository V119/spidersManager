package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsSohuPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSSohuPostService {
    //更新或新增搜狐
    public boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost);
    public BbsSohuPostEntity getBbsSohuPost(String id);

    List<BbsSohuPostEntity> getbbssohuPost(String authorID);
}
