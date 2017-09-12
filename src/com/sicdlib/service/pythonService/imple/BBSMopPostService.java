package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSMopPostDAO;
import com.sicdlib.dto.entity.BbsMopPostEntity;
import com.sicdlib.service.pythonService.IBBSMopPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/5/26.
 */
@Service("bbsMopPostService")
public class BBSMopPostService implements IBBSMopPostService {
    @Autowired
    @Qualifier("bbsMopPostDAO")
    private IBBSMopPostDAO bbsMopPostDAO;
    @Override
    public boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost) {
        if(bbsMopPost.getId() == null){
            String uuid = UUIDUtil.getUUID();
            bbsMopPost.setId(uuid);
        }
        return bbsMopPostDAO.saveBBSMopPost(bbsMopPost);
    }

    @Override
    public BbsMopPostEntity getBbsMopPost(String id) {
        return  bbsMopPostDAO.getBbsMopPost(id);
    }

}
