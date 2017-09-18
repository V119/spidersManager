package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSChinaAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaAuthorEntity;
import org.apache.hadoop.hbase.security.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

/**
 * Created by init on 2017/5/25.
 */
@Repository("bbsChinaAuthorDAO")
public class BBSChinaAuthorDAO implements IBBSChinaAuthorDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean savebbsChinaAuthor(BbsChinaAuthorEntity bbsChinaAuthor) {
        try {
            baseDAO.save(bbsChinaAuthor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BbsChinaAuthorEntity> getBbsChinaAuthorByPage(int pageStart, int pageSize) {
        String hql = "FROM BbsChinaAuthorEntity bbsChinaAuthor order by author_name desc limit '" + pageStart + "','"+ pageSize +"'";
        return baseDAO.find(hql);
    }

    @Override
    public int getAllAuthorNum() {
        String hql = "select count(*) FROM BbsChinaAuthorEntity bbsChinaAuthor";
        return baseDAO.executeSql(hql);
    }

    @Override
    public List<BbsChinaAuthorEntity> getBbsChinaAuthor() {
        String hql = "FROM BbsChinaAuthorEntity bbsChinaAuthor";
//        String sql = "select * from bbs_china_author limit 1000";
//        Session session = baseDAO.getCurrentSession();
//        List result = session.createSQLQuery(sql).getQueryReturns();
//        return result;
        return baseDAO.find(hql);
    }

    @Override
    public BbsChinaAuthorEntity getBbsChinaAuthorInfoByID(String authorID) {
        String hql = "FROM BbsChinaAuthorEntity bc where bc.authorId = "+authorID;
        return (BbsChinaAuthorEntity) baseDAO.get(hql);
    }
}
