package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.KdnetAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETAuthorService {
    //更新或新增凯迪社区
    public  boolean saveKDNETAuthor(KdnetAuthorEntity kdnetAuthor);

    public List<KdnetAuthorEntity> getBbsKDAuthor();
}
