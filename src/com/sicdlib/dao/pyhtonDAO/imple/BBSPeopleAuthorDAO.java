package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSPeopleAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsPeopleAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/5/30.
 */
@Repository("bbsPeopleAuthorDAO")
public class BBSPeopleAuthorDAO implements IBBSPeopleAuthorDAO {
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBBSPeopleAuthor(BbsPeopleAuthorEntity bbsPeopleAuthor) {
        try{
            baseDAO.save(bbsPeopleAuthor);
            return true;
        }catch(Exception e){
           e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<BbsPeopleAuthorEntity> getBbsPeopleAuthor() {
        String hql = "FROM BbsPeopleAuthorEntity";
        return baseDAO.find(hql);
    }
}
