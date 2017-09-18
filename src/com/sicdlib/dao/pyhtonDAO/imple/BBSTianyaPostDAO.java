package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSTianyaPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsTianyaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsTianyaPostDAO")
public class BBSTianyaPostDAO implements IBBSTianyaPostDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSTianyaPost(BbsTianyaPostEntity bbsTianyaPost) {
        try{
            baseDAO.save(bbsTianyaPost);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BbsTianyaPostEntity getBbsTianyaPost(String id) {
        String hql = "from BbsTianyaPostEntity ty where ty.id = '" + id + "'";
        return (BbsTianyaPostEntity) baseDAO.get(hql);
    }

    @Override
    public List<BbsTianyaPostEntity> getbbstianyaPost(String authorID) {
        return null;
    }
}
