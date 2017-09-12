package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsChinaPostDAO")
public class BBSChinaPostDAO implements IBBSChinaPostDAO {
    @Autowired
    private IBaseDAO baseDAO;


    @Override
    public Boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost) {
        try {
            baseDAO.save(bbsChinaPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BbsChinaPostEntity getBbsChinaPost(String id) {
        String hql = "from BbsChinaPostEntity cp where cp.id ='" + id + "'";
        return (BbsChinaPostEntity) baseDAO.get(hql);
    }
}
