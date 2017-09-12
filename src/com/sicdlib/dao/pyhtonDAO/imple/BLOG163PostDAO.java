package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOG163PostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.Blog163PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blog163PostDAO")
public class BLOG163PostDAO implements IBLOG163PostDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveBLOG163Post(Blog163PostEntity blog163Post) {
        try{
            baseDAO.save(blog163Post);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Blog163PostEntity getBlog163Post(String id) {
        String hql = "from Blog163PostEntity bp where bp.id = '"+ id +"' ";
        return (Blog163PostEntity) baseDAO.get(hql);
    }
}
