package com.sicdlib.dao.hbaseDAO.imple;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Restrictions;
import com.google.common.collect.Lists;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ITableColumnDAO;
import com.sicdlib.dao.hbaseDAO.IPostDAO;
import com.sicdlib.dto.phoenixEntity.BBSChinaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDAO")
public class PostDAO implements IPostDAO {
    @Autowired
    DataStoreApi dataStoreApi;

    @Autowired
    @Qualifier("tableColumnDAO")
    private ITableColumnDAO tableColumnDAO;

    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Override
    public int getAllPostNum(String tableName) {
        return 0;
    }

    @Override
    public List getPostList(String tableName,String authorID) {
        final QuerySelect<BBSChinaPostEntity, BBSChinaPostEntity> query = QueryBuilder
                .builderFor(BBSChinaPostEntity.class)
                .add(Restrictions.eq("\"author_id\"", authorID))
                .select().build();
        Iterable<BBSChinaPostEntity> infoItems = dataStoreApi.findAll(query);

        return Lists.newArrayList(infoItems);
    }

    @Override
    public Object getPostInfo(String postId, String tableName) {
        final QuerySelect<BBSChinaPostEntity, BBSChinaPostEntity> query = QueryBuilder
                .builderFor(BBSChinaPostEntity.class)
                .add(Restrictions.eq("\"post_id\"", postId))
                .select().build();
        BBSChinaPostEntity infoItems = dataStoreApi.findOne(query);
        System.out.println(infoItems.toString());

        return  infoItems;
    }
}
