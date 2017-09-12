package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSMopPostDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.dto.entity.BbsMopPostEntity;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsMopPostDAO")
public class BBSMopPostDAO implements IBBSMopPostDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean saveBBSMopPost(BbsMopPostEntity bbsMopPost) {
        try{
           baseDAO.save(bbsMopPost);
           return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public void batchNormalizeContent() {
        StatelessSession session = sessionFactory.openStatelessSession();
        Transaction tx = session.beginTransaction();

        ScrollableResults posts = session.createQuery("from BbsMopPostEntity")
                .scroll(ScrollMode.FORWARD_ONLY);
        while (posts.next()) {
            BbsMopPostEntity post = (BbsMopPostEntity)posts.get(0);

            //去除内容中前后空格符
            post.setContent(post.getContent().trim());

            session.update(post);
        }

        tx.commit();
        session.close();
    }

    @Override
    public BbsMopPostEntity getBbsMopPost(String id) {
        String hql = "from BbsMopPostEntity mp where mp.id = ' "+ id +" '";
        return (BbsMopPostEntity) baseDAO.get(hql);
    }

}
