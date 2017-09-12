package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.Blog163PostEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOG163PostService {
    //更新或新增网易博客
    public boolean saveBLOG163Post(Blog163PostEntity blog163Post);
    Blog163PostEntity getBlog163Post(String id);
}
