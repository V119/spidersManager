package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IWEIBOCommentDAO;
import com.sicdlib.dto.entity.WeiboCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("weiboCommentDAO")
public class WEIBOCommentDAO implements IWEIBOCommentDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveWEIBOComment(WeiboCommentEntity weiboComment) {
        try{
            baseDAO.save(weiboComment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}