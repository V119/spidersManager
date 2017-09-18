package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOG163AuthorDAO;
import com.sicdlib.dto.entity.Blog163AuthorEntity;
import com.sicdlib.service.pythonService.IBLOG163AuthorService;

import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
@Service("blog163AuthorService")
public class BLOG163AuthorService  implements IBLOG163AuthorService{
    @Autowired
    @Qualifier("blog163AuthorDAO")
    private IBLOG163AuthorDAO blog163AuthorDAO;
    @Override
    public boolean saveBLOG163Author(Blog163AuthorEntity blog163Author) {
        if(blog163Author.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            blog163Author.setId(uuid);
        }
        return blog163AuthorDAO.saveBLOG163Author(blog163Author);
    }

    @Override
    public List<Blog163AuthorEntity> getBlog163Author() {
        return blog163AuthorDAO.getBlog163Author();
    }
}
