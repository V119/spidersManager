package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSSohuPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsSohuPostDAO")
public class BBSSohuPostDAO  implements IBBSSohuPostDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSSohuPost(BbsSohuPostEntity bbsSohuPost) {
        try{
            baseDAO.save(bbsSohuPost);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public BbsSohuPostEntity getBbsSohuPost(String id) {
        String hql = "from BbsSohuPostEntity sh where sh.id ='" + id + "'";
        return (BbsSohuPostEntity) baseDAO.get(hql);
    }

    @Override
    public List<BbsSohuPostEntity> getbbssohuPost(String authorID) {
        return null;
    }
}
