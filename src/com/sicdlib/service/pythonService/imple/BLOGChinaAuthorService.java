package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGChinaAuthorDAO;
import com.sicdlib.dto.entity.BlogchinaAuthorEntity;
import com.sicdlib.service.pythonService.IBLOGChinaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by init on 2017/6/3.
 */
@Service("blogChinaAuthorService")
public class BLOGChinaAuthorService  implements IBLOGChinaAuthorService {
    @Autowired
    @Qualifier("blogChinaAuthorDAO")
    private IBLOGChinaAuthorDAO blogChinaAuthorDAO;
    @Override
    public boolean saveBLOGChinaAuthor(BlogchinaAuthorEntity blogchinaAuthor) {
        if(blogchinaAuthor.getId() ==null){
         String uuid = UUIDUtil.getUUID();
         blogchinaAuthor.setId(uuid);
        }
        return blogChinaAuthorDAO.saveBLOGChinaAuthor(blogchinaAuthor);
    }
}
