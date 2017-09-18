package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaAuthorDAO;
import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import com.sicdlib.service.pythonService.IBBSChinaAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/5/25.
 */
@Service("bbsChinaAuthorService")
public class BBSChinaAuthorService implements IBBSChinaAuthorService {
     @Autowired
     @Qualifier("bbsChinaAuthorDAO")
      private IBBSChinaAuthorDAO bbsChinaAuthorDAO;

    @Override
    public boolean saveBBSChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor) {
        if (bbsChinaAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsChinaAuthor.setId(uuid);
        }
        return bbsChinaAuthorDAO.savebbsChinaAuthor(bbsChinaAuthor);
    }

    @Override
    public List<BbsChinaAuthorEntity> getBbsChinaAuthorByPage(int pageStart, int pageSize) {
        return bbsChinaAuthorDAO.getBbsChinaAuthorByPage(pageStart,pageSize);
    }


    @Override
    public int getAllAuthorNum() {
        return bbsChinaAuthorDAO.getAllAuthorNum();
    }

    @Override
    public List<BbsChinaAuthorEntity> getBbsChinaAuthor() {
        return bbsChinaAuthorDAO.getBbsChinaAuthor();
    }

    @Override
    public BbsChinaAuthorEntity getBbsChinaAuthorInfoByID(String authorID) {
        return bbsChinaAuthorDAO.getBbsChinaAuthorInfoByID(authorID);
    }
}
