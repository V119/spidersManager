package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;

import java.util.List;

/**
 * Created by init on 2017/5/31.
 */
public interface IBBSPeoplePostDAO {
    Boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost);
    List<BbsPeoplePostEntity> getAllBbsPeoplePosts();
    BbsPeoplePostEntity getBbsPeoplePost(String id);

    List<BbsPeoplePostEntity> getbbspeoplePost(String authorID);
}
