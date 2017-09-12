package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOGChinaBlogDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BlogchinaBlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blogChinaBlogDAO")
public class BLOGChinaBlogDAO  implements IBLOGChinaBlogDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBLOGChinaBlog(BlogchinaBlogEntity blogchinaBlog) {
       try{
           baseDAO.save(blogchinaBlog);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }

    @Override
    public BlogchinaBlogEntity getBlogchinaBlog(String id) {
        String hql = "from BlogchinaBlogEntity bc where bc.id = '"+ id +"' ";
        return (BlogchinaBlogEntity) baseDAO.get(hql);
    }
}
