package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsXiciAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSXiciAuthorDAO {
    Boolean saveBBSXiciAuthor(BbsXiciAuthorEntity bbsXiciAuthor);
    List<BbsXiciAuthorEntity> getBbsXiciAuthor();
}
