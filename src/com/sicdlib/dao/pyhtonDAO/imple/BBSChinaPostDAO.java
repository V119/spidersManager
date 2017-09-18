package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.TbArticleSimilarityEntity;
import com.sicdlib.dto.entity.BbsChinaPostEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsChinaPostDAO")
public class BBSChinaPostDAO implements IBBSChinaPostDAO {
    @Autowired
    private IBaseDAO baseDAO;


    @Override
    public Boolean saveBBSChinaPost(BbsChinaPostEntity bbsChinaPost) {
        try {
            baseDAO.save(bbsChinaPost);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BbsChinaPostEntity getBbsChinaPost(String id) {
        String hql = "from BbsChinaPostEntity cp where cp.id ='" + id + "'";
        return (BbsChinaPostEntity) baseDAO.get(hql);
    }

    @Override
    public List<BbsChinaPostEntity> getbbsChinaPost(String authorID) {
        /*String hql = "FROM BbsChinaPostEntity where authorId = '" + authorID + "'";
        return (List<BbsChinaPostEntity>) baseDAO.get(hql);*/
        return null;

    }

    @Override
    public BbsChinaPostEntity getBbsChinaPostInfoByID(String postID) {
        String hql = "from BbsChinaPostEntity where postId ='" + postID + "'";
        return (BbsChinaPostEntity) baseDAO.get(hql);
    }
}
