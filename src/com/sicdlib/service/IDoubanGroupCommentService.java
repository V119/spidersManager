package com.sicdlib.service;

import com.sicdlib.dto.DoubanGroupCommentEntity;

public interface IDoubanGroupCommentService {
    //新增or更新豆瓣小组评论
    public boolean saveDoubanGroupComment(DoubanGroupCommentEntity doubanGroupComment);
}