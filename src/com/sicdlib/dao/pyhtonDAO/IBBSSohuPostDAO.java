package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsSohuPostEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSSohuPostDAO {
    Boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost);
    BbsSohuPostEntity getBbsSohuPost(String id);

    List<BbsSohuPostEntity> getbbssohuPost(String authorID);
}
