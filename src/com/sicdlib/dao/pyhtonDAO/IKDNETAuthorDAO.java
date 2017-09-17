package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.KdnetAuthorEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
public interface IKDNETAuthorDAO {
    Boolean saveKDNETAuthor(KdnetAuthorEntity kdnetAuthor);
    List<KdnetAuthorEntity> getBbsKDAuthor();
}
