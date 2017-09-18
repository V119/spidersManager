package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.DoubanGroupGroupEntity;

/**
 * Created by init on 2017/5/25.
 */
public interface IDoubanGroupGroupService {
    //新增or更新豆瓣小组发布
    boolean saveDoubanGroupGroup(DoubanGroupGroupEntity doubanGroupGroup);
}
