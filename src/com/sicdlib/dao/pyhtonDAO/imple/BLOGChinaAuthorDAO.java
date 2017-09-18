package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGChinaAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BlogchinaAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blogChinaAuthorDAO")
public class BLOGChinaAuthorDAO  implements IBLOGChinaAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBLOGChinaAuthor(BlogchinaAuthorEntity blogchinaAuthor) {
        try{
            baseDAO.save(blogchinaAuthor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BlogchinaAuthorEntity> getBlogChinaAuthor() {
        String hql = "FROM BlogchinaAuthorEntity";
        return baseDAO.find(hql);
    }
}
