package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;

import java.util.List;

public interface IDoubanGroupAuthorDAO {
    Boolean saveDoubanGroupAuthor(DoubanGroupAuthorEntity doubanGroupAuthor);

    List<DoubanGroupAuthorEntity> getDoubanAuthor();
}
