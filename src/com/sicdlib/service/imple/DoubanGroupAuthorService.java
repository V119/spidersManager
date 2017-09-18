package com.sicdlib.service.imple;

import com.sicdlib.dao.pyhtonDAO.IDoubanGroupAuthorDAO;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;
import com.sicdlib.service.pythonService.IDoubanGroupAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yh on 2016/9/8.
 */
@Service("doubanGroupAuthorService")
public class DoubanGroupAuthorService implements IDoubanGroupAuthorService{
    @Autowired
    @Qualifier("doubanGroupAuthorDAO")
    private IDoubanGroupAuthorDAO doubanGroupAuthorDAO;

    @Override
    public boolean saveDoubanGroupAuthor(DoubanGroupAuthorEntity doubanGroupAuthor) {
        if (doubanGroupAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            doubanGroupAuthor.setId(uuid);
        }
        return doubanGroupAuthorDAO.saveDoubanGroupAuthor(doubanGroupAuthor);
    }

    @Override
    public List<DoubanGroupAuthorEntity> getDoubanAuthor() {
        return null;
    }
}
