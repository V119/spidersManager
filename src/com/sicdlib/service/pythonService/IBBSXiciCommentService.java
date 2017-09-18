package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsXiciCommentEntity;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSXiciCommentService {
    //更新或新增西祠
    boolean saveBBSXiciComment(BbsXiciCommentEntity bbsXiciComment);
}
