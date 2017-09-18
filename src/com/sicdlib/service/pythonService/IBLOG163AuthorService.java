package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.Blog163AuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOG163AuthorService {
    //更新或新增网易博客
    boolean saveBLOG163Author(Blog163AuthorEntity blog163Author);

    List<Blog163AuthorEntity> getBlog163Author();
}
