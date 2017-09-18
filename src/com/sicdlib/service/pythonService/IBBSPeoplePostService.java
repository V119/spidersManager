package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;

import java.util.List;

/**
 * Created by init on 2017/5/31.
 */
public interface IBBSPeoplePostService {
    //更新或新增bbsPeoplePost
    boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost);
    //
    List<BbsPeoplePostEntity> getAllBbsPeoplePosts();
    public BbsPeoplePostEntity getBbsPeoplePost(String id);

    List<BbsPeoplePostEntity> getbbspeoplePost(String authorID);
}
