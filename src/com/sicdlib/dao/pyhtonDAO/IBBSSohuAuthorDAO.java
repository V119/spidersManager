package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsSohuAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
public interface IBBSSohuAuthorDAO {
    Boolean saveBBSSohuAuthor(BbsSohuAuthorEntity bbsSohuAuthor);
    List<BbsSohuAuthorEntity> getBbsSohuAuthor();
}
