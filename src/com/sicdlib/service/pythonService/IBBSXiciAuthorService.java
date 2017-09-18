package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsXiciAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSXiciAuthorService {
    //更新或新增西祠
    boolean saveBBSXiciAuthor(BbsXiciAuthorEntity bbsXiciAuthor);

    List<BbsXiciAuthorEntity> getBbsXiciAuthor();
}
