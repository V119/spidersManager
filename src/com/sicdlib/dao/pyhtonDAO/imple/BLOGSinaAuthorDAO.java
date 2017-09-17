package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGSinaAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BlogSinaAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blogSinaAuthorDAO")
public class BLOGSinaAuthorDAO  implements IBLOGSinaAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBLOGSinaAuthor(BlogSinaAuthorEntity blogSinaAuthor) {
        try{
                baseDAO.save(blogSinaAuthor);
                return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BlogSinaAuthorEntity> getBlogSinaAuthor() {
        String hql = "FROM BlogSinaAuthorEntity";
        return baseDAO.find(hql);
    }
}
