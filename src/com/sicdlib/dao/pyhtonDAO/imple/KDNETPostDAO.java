package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IKDNETPostDAO;
import com.sicdlib.dto.entity.KdnetPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
@Repository("kdnetPostDAO")
public class KDNETPostDAO  implements IKDNETPostDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveKDNETPost(KdnetPostEntity kdnetPost) {
        try{
          baseDAO.save(kdnetPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public KdnetPostEntity getKdnetPost(String id) {
        String hql = "from  KdnetPostEntity k where k.id =' " + id + "'";
        return (KdnetPostEntity) baseDAO.get(hql);
    }

    @Override
    public List<KdnetPostEntity> getbbskdPost(String authorID) {
        return null;
    }
}
