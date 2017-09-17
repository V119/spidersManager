package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSTianyaAuthorDAO;
import com.sicdlib.dto.entity.BbsTianyaAuthorEntity;
import com.sicdlib.service.pythonService.IBBSTianyaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsTianyaAuthorService")
public class BBSTianyaAuthorService implements IBBSTianyaAuthorService{
    @Autowired
    @Qualifier("bbsTianyaAuthorDAO")
    private IBBSTianyaAuthorDAO bbsTianyaAuthorDAO;

    @Override
    public boolean saveBBSTianyaAuthor(BbsTianyaAuthorEntity bbsTianyaAuthor) {
        if(bbsTianyaAuthor.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsTianyaAuthor.setId(uuid);
        }
        return bbsTianyaAuthorDAO.saveBBSTianyaAuthor(bbsTianyaAuthor);
    }

    @Override
    public List<BbsTianyaAuthorEntity> getBbsTianyaAuthor() {
        return bbsTianyaAuthorDAO.getBbsTianyaAuthor();
    }
}
