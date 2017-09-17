package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsPeopleAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/5/30.
 */
public interface IBBSPeopleAuthorService {
    //新增或更新bbsPeople
    public  boolean saveBBSPeopleAuthor(BbsPeopleAuthorEntity bbsPeopleAuthor);
    public List<BbsPeopleAuthorEntity> getBbsPeopleAuthor();
}
