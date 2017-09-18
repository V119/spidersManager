package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsMopCommentEntity;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopCommentService {
    //更新or新增猫扑社区的评论
    boolean saveBBSMopComment(BbsMopCommentEntity bbsMopComment);
}
