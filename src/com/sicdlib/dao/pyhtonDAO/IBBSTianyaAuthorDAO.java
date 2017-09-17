package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsTianyaAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSTianyaAuthorDAO {
    Boolean  saveBBSTianyaAuthor(BbsTianyaAuthorEntity bbsTianyaAuthor);
    List<BbsTianyaAuthorEntity> getBbsTianyaAuthor();
}
