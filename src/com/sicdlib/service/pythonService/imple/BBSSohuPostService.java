package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSSohuPostDAO;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import com.sicdlib.service.pythonService.IBBSSohuPostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Service("bbsSohuPostService")
public class BBSSohuPostService implements IBBSSohuPostService{
    @Autowired
    @Qualifier("bbsSohuPostDAO")
    private IBBSSohuPostDAO bbsSohuPostDAO;
    @Override
    public boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost) {
        if(bbsSohuPost.getId() ==null){
            String uuid = UUIDUtil.getUUID();
            bbsSohuPost.setId(uuid);
        }
        return bbsSohuPostDAO.saveBBSSohuPost(bbsSohuPost);
    }

    @Override
    public BbsSohuPostEntity getBbsSohuPost(String id) {
        return bbsSohuPostDAO.getBbsSohuPost(id);
    }

    @Override
    public List<BbsSohuPostEntity> getbbssohuPost(String authorID) {
        return bbsSohuPostDAO.getbbssohuPost(authorID);
    }
}
