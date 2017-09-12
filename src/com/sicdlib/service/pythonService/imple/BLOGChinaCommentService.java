package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGChinaCommentDAO;
import com.sicdlib.dto.entity.BlogchinaCommentEntity;
import com.sicdlib.service.pythonService.IBLOGChinaCommentService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blogChinaCommentService")
public class BLOGChinaCommentService implements IBLOGChinaCommentService{
    @Autowired
    @Qualifier("blogChinaCommentDAO")
    private IBLOGChinaCommentDAO blogChinaCommentDAO;
    @Override
    public boolean saveBLOGChinaComment(BlogchinaCommentEntity blogchinaComment) {
        if(blogchinaComment.getId()  ==null){
            String uuid = UUIDUtil.getUUID();
            blogchinaComment.setId(uuid);
        }
        return blogChinaCommentDAO.saveBLOGChinaComment(blogchinaComment);
    }
}
