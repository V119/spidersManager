package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IXINWEN110NewsDAO;
import com.sicdlib.dto.entity.Xinwen110NewsEntity;
import com.sicdlib.service.pythonService.IXINWEN110NewsService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by init on 2017/6/5.
 */
@Service("xinwen110NewsService")
public class XINWEN110NewsService implements IXINWEN110NewsService{
    @Autowired
    @Qualifier("xinwen110NewsDAO")
    private IXINWEN110NewsDAO xinwen110NewsDAO;
    @Override
    public boolean saveXINWEN110News(Xinwen110NewsEntity xinwen110News) {
        if(xinwen110News.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            xinwen110News.setId(uuid);
        }
     return xinwen110NewsDAO.saveXINWEN110News(xinwen110News);
    }

    @Override
    public Xinwen110NewsEntity getXinwen110News(String id) {
        return xinwen110NewsDAO.getXinwen110News(id);
    }
}
