package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;

import java.util.List;

public interface IDoubanGroupPostService {
    //新增or更新豆瓣小组发布
    boolean saveDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost);
    List<DoubanGroupPostEntity> getAllDoubanGroupPost();
    DoubanGroupPostEntity getDoubanGroupPost(String id);

}
