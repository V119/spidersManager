package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGChinaCommentDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BlogchinaCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blogChinaCommentDAO")
public class BLOGChinaCommentDAO  implements IBLOGChinaCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBLOGChinaComment(BlogchinaCommentEntity blogchinaComment) {
        try{
            baseDAO.save(blogchinaComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
