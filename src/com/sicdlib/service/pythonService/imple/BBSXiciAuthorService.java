package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSXiciAuthorDAO;
import com.sicdlib.dto.entity.BbsXiciAuthorEntity;
import com.sicdlib.service.pythonService.IBBSXiciAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsXiciAuthorService")
public class BBSXiciAuthorService implements IBBSXiciAuthorService {
    @Autowired
    @Qualifier("bbsXiciAuthorDAO")
    private IBBSXiciAuthorDAO bbsXiciAuthorDAO;

    @Override
    public boolean saveBBSXiciAuthor(BbsXiciAuthorEntity bbsXiciAuthor) {
        if(bbsXiciAuthor.getId() ==null){
         String uuid = UUIDUtil.getUUID();
         bbsXiciAuthor.setId(uuid);
        }
        return bbsXiciAuthorDAO.saveBBSXiciAuthor(bbsXiciAuthor);
    }

    @Override
    public List<BbsXiciAuthorEntity> getBbsXiciAuthor() {
        return bbsXiciAuthorDAO.getBbsXiciAuthor();
    }
}
