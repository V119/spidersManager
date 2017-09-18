package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaAuthorService {
    //新增or更新bbs作者
    public boolean saveBBSChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor);
    //查询作者
    public List<BbsChinaAuthorEntity> getBbsChinaAuthorByPage(int pageStart, int pageSize);
    //查询所有作者的数量
    public int getAllAuthorNum();
    public List<BbsChinaAuthorEntity> getBbsChinaAuthor();
    BbsChinaAuthorEntity getBbsChinaAuthorInfoByID(String authorID);

}
