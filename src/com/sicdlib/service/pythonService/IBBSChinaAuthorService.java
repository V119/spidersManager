package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaAuthorService {
    //新增or更新bbs作者
    boolean saveBBSChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor);
    //查询作者
    List<BbsChinaAuthorEntity> getBbsChinaAuthorByPage(int pageStart, int pageSize);
    //查询所有作者的数量
    int getAllAuthorNum();
    List<BbsChinaAuthorEntity> getBbsChinaAuthor();
    BbsChinaAuthorEntity getBbsChinaAuthorInfoByID(String authorID);

}
