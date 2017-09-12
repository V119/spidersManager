package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGChinaBlogDAO;
import com.sicdlib.dto.entity.BlogchinaBlogEntity;
import com.sicdlib.service.pythonService.IBLOGChinaBlogService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/3.
 */
@Service("blogChinaBlogService")
public class BLOGChinaBlogService  implements IBLOGChinaBlogService{
    @Autowired
    @Qualifier("blogChinaBlogDAO")
    private IBLOGChinaBlogDAO blogChinaBlogDAO;
    @Override
    public boolean saveBLOGChinaBlog(BlogchinaBlogEntity blogchinaBlog) {
        if(blogchinaBlog.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            blogchinaBlog.setId(uuid);
        }
        return blogChinaBlogDAO.saveBLOGChinaBlog(blogchinaBlog);
    }

    @Override
    public BlogchinaBlogEntity getBlogchinaBlog(String id) {
        return blogChinaBlogDAO.getBlogchinaBlog(id);
    }
}
