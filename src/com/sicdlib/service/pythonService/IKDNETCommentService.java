package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.KdnetCommentEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETCommentService {
    //更新或新增凯迪社区
    boolean saveKDNETComment(KdnetCommentEntity kdnetComment);
}
