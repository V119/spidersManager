package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaPostEntity;
import com.sicdlib.dto.entity.BbsXiciPostEntity;

import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
public interface IBBSChinaPostService {
    //新增or更新中华网社区
    boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost);
    BbsChinaPostEntity getBbsChinaPost(String id);
    //根据作者ID查询所有文章
    List<BbsChinaPostEntity> getbbsChinaPost(String authorID);
    //根据文章ID查询文章信息
    BbsChinaPostEntity getBbsChinaPostInfoByID(String postID);
}
