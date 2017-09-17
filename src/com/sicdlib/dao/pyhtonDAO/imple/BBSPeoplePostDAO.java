package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSPeoplePostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/5/31.
 */
@Repository("bbsPeoplePostDAO")
public class BBSPeoplePostDAO implements IBBSPeoplePostDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        try{
         baseDAO.save(bbsPeoplePost);
         return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BbsPeoplePostEntity> getAllBbsPeoplePosts() {
        String hql = "from BbsPeoplePostEntity p";
        return baseDAO.find(hql);
    }

    @Override
    public BbsPeoplePostEntity getBbsPeoplePost(String id) {
        String hql = "from BbsPeoplePostEntity p where p.id = '" + id + "'";
        return (BbsPeoplePostEntity)baseDAO.get(hql);
    }

    @Override
    public List<BbsPeoplePostEntity> getbbspeoplePost(String authorID) {
        return null;
    }

}
