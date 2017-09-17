package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBLOG163AuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.Blog163AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
@Repository("blog163AuthorDAO")
public class BLOG163AuthorDAO  implements IBLOG163AuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveBLOG163Author(Blog163AuthorEntity blog163Author) {
        try{
            baseDAO.save(blog163Author);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Blog163AuthorEntity> getBlog163Author() {
        String hql = "FROM Blog163AuthorEntity";
        return baseDAO.find(hql);
    }
}
