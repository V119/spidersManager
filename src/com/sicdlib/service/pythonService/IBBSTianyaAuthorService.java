package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsTianyaAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSTianyaAuthorService {
    //更新或新增天涯
    boolean saveBBSTianyaAuthor(BbsTianyaAuthorEntity bbsTianyaAuthor);
    List<BbsTianyaAuthorEntity> getBbsTianyaAuthor();
}
