package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsPeopleAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/5/30.
 */
public interface IBBSPeopleAuthorDAO {
    Boolean saveBBSPeopleAuthor(BbsPeopleAuthorEntity bbsPeopleAuthor);
    List<BbsPeopleAuthorEntity> getBbsPeopleAuthor();
}
