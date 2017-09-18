package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IKDNETPostDAO;
import com.sicdlib.dto.entity.KdnetPostEntity;
import com.sicdlib.service.pythonService.IKDNETPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
@Service("kdnetPostService")
public class KDNETPostService  implements IKDNETPostService{
    @Autowired
    @Qualifier("kdnetPostDAO")
    private IKDNETPostDAO kdnetPostDAO;
    @Override
    public boolean saveKDNETPost(KdnetPostEntity kdnetPost) {
        if(kdnetPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            kdnetPost.setId(uuid);
        }
        return kdnetPostDAO.saveKDNETPost(kdnetPost);
    }

    @Override
    public KdnetPostEntity getKdnetPost(String id) {
        return kdnetPostDAO.getKdnetPost(id);
    }

    @Override
    public List<KdnetPostEntity> getbbskdPost(String authorID) {
        return kdnetPostDAO.getbbskdPost(authorID);
    }
}
