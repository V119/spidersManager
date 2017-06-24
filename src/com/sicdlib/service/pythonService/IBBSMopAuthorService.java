package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;

import java.text.ParseException;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopAuthorService {
    //新增or更新猫扑社区
    public boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor);

    void normalizeSexAgeBirthdayRegisterDate() throws ParseException;
}
