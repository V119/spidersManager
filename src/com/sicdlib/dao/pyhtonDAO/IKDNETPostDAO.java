package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.KdnetPostEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETPostDAO {
    Boolean saveKDNETPost(KdnetPostEntity kdnetPost);
    KdnetPostEntity getKdnetPost(String id);
}
