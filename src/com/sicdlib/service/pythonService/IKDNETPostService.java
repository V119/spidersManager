package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.KdnetPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETPostService {
    //更新或新增凯迪社区
    boolean saveKDNETPost(KdnetPostEntity kdnetPost);
    KdnetPostEntity getKdnetPost(String id);

    List<KdnetPostEntity> getbbskdPost(String authorID);
}
