package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.IDoubanGroupAuthorDAO;
import com.sicdlib.dto.entity.DoubanGroupAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yh on 2016/9/8.
 */
@Repository("doubanGroupAuthorDAO")
public class DoubanGroupAuthorDAO implements IDoubanGroupAuthorDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveDoubanGroupAuthor(DoubanGroupAuthorEntity doubanGroupAuthor) {
        try {
            baseDAO.save(doubanGroupAuthor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
