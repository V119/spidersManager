package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import com.sicdlib.dto.entity.DoubanGroupCommentEntity;

/**
 * Created by init on 2017/5/25.
 */
public interface IBBSChinaCommentService {
    //新增or更新中华网社区
    boolean saveBBSChinaComment(BbsChinaCommentEntity bbsChinaComment);

    /**
     * 规范化表中的作者名字段和评论内容字段
     */
    void normalizeAuthorNameAndContent();
}
