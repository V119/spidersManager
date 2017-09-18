package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;

import java.text.ParseException;
import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopAuthorService {
    //新增or更新猫扑社区
    boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor);

    void normalizeSexAgeBirthdayRegisterDate() throws ParseException;

    List<BbsMopAuthorEntity> getBbsMopAuthor();
}
