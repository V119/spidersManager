package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IKDNETAuthorDAO;
import com.sicdlib.dto.entity.KdnetAuthorEntity;
import com.sicdlib.service.pythonService.IKDNETAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
@Service("kdnetAuthorService")
public class KDNETAuthorService  implements IKDNETAuthorService{
    @Autowired
    @Qualifier("kdnetAuthorDAO")
    private IKDNETAuthorDAO kdnetAuthorDAO;
    @Override
    public boolean saveKDNETAuthor(KdnetAuthorEntity kdnetAuthor) {
        if(kdnetAuthor.getId() == null){
            String uuid = UUIDUtil.getUUID();
            kdnetAuthor.setId(uuid);
        }
        return kdnetAuthorDAO.saveKDNETAuthor(kdnetAuthor);
    }

    @Override
    public List<KdnetAuthorEntity> getBbsKDAuthor() {
        return kdnetAuthorDAO.getBbsKDAuthor();
    }
}
