package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSTianyaPostDAO;
import com.sicdlib.dto.entity.BbsTianyaPostEntity;
import com.sicdlib.service.pythonService.IBBSTianyaPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsTianyaPostService")
public class BBSTianyaPostService  implements IBBSTianyaPostService{
    @Autowired
    @Qualifier("bbsTianyaPostDAO")
    private IBBSTianyaPostDAO bbsTianyaPostDAO;
    @Override
    public boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost) {
        if(bbsTianyaPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsTianyaPost.setId(uuid);
        }
        return bbsTianyaPostDAO.saveBBSTianyaPost(bbsTianyaPost);
    }

    @Override
    public BbsTianyaPostEntity getBbsTianyaPost(String id) {
        return bbsTianyaPostDAO.getBbsTianyaPost(id);
    }

    @Override
    public List<BbsTianyaPostEntity> getbbstianyaPost(String authorID) {
        return bbsTianyaPostDAO.getbbstianyaPost(authorID);
    }
}
