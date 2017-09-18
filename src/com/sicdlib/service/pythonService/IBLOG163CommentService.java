package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.Blog163CommentEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOG163CommentService {
    //更新或新增网易博客
    boolean saveBLOG163Comment(Blog163CommentEntity blog163Comment);
}
