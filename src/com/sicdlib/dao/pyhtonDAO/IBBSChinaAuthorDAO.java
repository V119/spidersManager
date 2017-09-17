package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaAuthorDAO {
    Boolean savebbsChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor);
    List<BbsChinaAuthorEntity> getBbsChinaAuthorByPage(int pageStart, int pageSize);
    int getAllAuthorNum();
    List<BbsChinaAuthorEntity> getBbsChinaAuthor();

    BbsChinaAuthorEntity getBbsChinaAuthorInfoByID(String authorID);

}
