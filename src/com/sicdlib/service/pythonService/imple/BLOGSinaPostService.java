package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGSinaPostDAO;
import com.sicdlib.dto.entity.BlogSinaPostEntity;
import com.sicdlib.service.pythonService.IBLOGSinaPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blogSinaPostService")
public class BLOGSinaPostService  implements IBLOGSinaPostService{
    @Autowired
    @Qualifier("blogSinaPostDAO")
    private IBLOGSinaPostDAO blogSinaPostDAO;

    @Override
    public boolean saveBLOGSinaPost(BlogSinaPostEntity blogSinaPost) {
        if(blogSinaPost.getId() == null){
            String uuid = UUIDUtil.getUUID();
            blogSinaPost.setId(uuid);
        }
        return blogSinaPostDAO.saveBLOGSinaPost(blogSinaPost);
    }

    @Override
    public BlogSinaPostEntity getBlogSinaPost(String id) {
        return blogSinaPostDAO.getBlogSinaPost(id);
    }
}
