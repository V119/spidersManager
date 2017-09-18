package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IXINHUANewsDAO;
import com.sicdlib.dto.entity.XinhuaNewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/5.
 */
@Repository("xinhuaNewsDAO")
public class XINHUANewsDAO  implements IXINHUANewsDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveXINHUANews(XinhuaNewsEntity xinhuaNews) {
        try{
            baseDAO.save(xinhuaNews);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<XinhuaNewsEntity> getAllXinHuaNews() {
        String hql = "from XinhuaNewsEntity xh";
        return baseDAO.find(hql);
    }

    @Override
    public XinhuaNewsEntity getAllXinHuaNewsByArticleID(String id) {
        String hql = "from XinhuaNewsEntity xh where xh.id = '"+ id +"'";
        return (XinhuaNewsEntity)baseDAO.get(hql);
    }

    @Override
    public List<XinhuaNewsEntity> getBbsXinhuaAuthor() {
        return null;
    }

}
