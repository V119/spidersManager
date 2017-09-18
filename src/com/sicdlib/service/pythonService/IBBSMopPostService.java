package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.dto.entity.BbsMopPostEntity;

import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopPostService {
    //新增orgengxin猫扑社区文章
    boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost);
    BbsMopPostEntity getBbsMopPost(String id);

    List<BbsMopAuthorEntity> getbbsmopPost(String authorID);
}
