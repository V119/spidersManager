package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSSohuAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsSohuAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/2.
 */
@Repository("bbsSohuAuthorDAO")
public class BBSSohuAuthorDAO implements IBBSSohuAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBBSSohuAuthor(BbsSohuAuthorEntity bbsSohuAuthor) {
        try{
            baseDAO.save(bbsSohuAuthor);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public List<BbsSohuAuthorEntity> getBbsSohuAuthor() {
        String hql = "FROM BbsSohuAuthorEntity";
        return baseDAO.find(hql);
    }
}
