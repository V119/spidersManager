package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.ParseException;
import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSMopAuthorDAO {
    Boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor);
    void batchNormalizeSexAgeBirthdayRegisterDate() throws ParseException;
    List<BbsMopAuthorEntity> getBbsMopAuthor();
}
