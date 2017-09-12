package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOG163PostDAO;
import com.sicdlib.dto.entity.Blog163PostEntity;
import com.sicdlib.service.pythonService.IBLOG163PostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blog163PostService")
public class BLOG163PostService  implements IBLOG163PostService{
    @Autowired
    @Qualifier("blog163PostDAO")
    private IBLOG163PostDAO blog163PostDAO;
    @Override
    public boolean saveBLOG163Post(Blog163PostEntity blog163Post) {
        if(blog163Post.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            blog163Post.setId(uuid);
        }
        return blog163PostDAO.saveBLOG163Post(blog163Post);
    }

    @Override
    public Blog163PostEntity getBlog163Post(String id) {
        return blog163PostDAO.getBlog163Post(id);
    }
}
