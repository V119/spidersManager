package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSPeoplePostDAO;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.service.pythonService.IBBSPeoplePostService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/5/31.
 */
@Service("bbsPeoplePostService")
public class BBSPeoplePostService implements IBBSPeoplePostService {
    @Autowired
    @Qualifier("bbsPeoplePostDAO")
    private IBBSPeoplePostDAO bbsPeoplePostDAO;

    @Override
    public boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        if(bbsPeoplePost.getId()==null){
            String uuid = UUIDUtil.getUUID();
            bbsPeoplePost.setId(uuid);
        }
        return bbsPeoplePostDAO.saveBBSPeoplePost(bbsPeoplePost);
    }

    @Override
    public List<BbsPeoplePostEntity> getAllBbsPeoplePosts() {
        return bbsPeoplePostDAO.getAllBbsPeoplePosts();
    }

    @Override
    public BbsPeoplePostEntity getBbsPeoplePost(String id) {
        return bbsPeoplePostDAO.getBbsPeoplePost(id);
    }

    @Override
    public List<BbsPeoplePostEntity> getbbspeoplePost(String authorID) {
        return bbsPeoplePostDAO.getbbspeoplePost(authorID);
    }

}
