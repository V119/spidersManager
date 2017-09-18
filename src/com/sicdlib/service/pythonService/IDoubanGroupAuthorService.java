package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;

import java.util.List;

public interface IDoubanGroupAuthorService {
    //新增or更新豆瓣小组作者
    boolean saveDoubanGroupAuthor(DoubanGroupAuthorEntity doubanGroupAuthor);

    List<DoubanGroupAuthorEntity> getDoubanAuthor();
}
