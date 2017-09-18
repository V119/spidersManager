package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSSohuAuthorDAO;
import com.sicdlib.dto.entity.BbsSohuAuthorEntity;
import com.sicdlib.service.pythonService.IBBSSohuAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsSohuAuthorService")
public class BBSSohuAuthorService implements IBBSSohuAuthorService {
    @Autowired
    @Qualifier("bbsSohuAuthorDAO")
    private IBBSSohuAuthorDAO bbsSohuAuthorDAO;
    @Override
    public boolean saveBBSSohuAuthor(BbsSohuAuthorEntity bbsSohuAuthor) {
        if(bbsSohuAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsSohuAuthor.setId(uuid);
        }
        return bbsSohuAuthorDAO.saveBBSSohuAuthor(bbsSohuAuthor);
    }

    @Override
    public List<BbsSohuAuthorEntity> getBbsSohuAuthor() {
        return bbsSohuAuthorDAO.getBbsSohuAuthor();
    }
}
