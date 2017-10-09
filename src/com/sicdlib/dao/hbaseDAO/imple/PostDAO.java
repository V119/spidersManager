package com.sicdlib.dao.hbaseDAO.imple;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Ordering;
import com.eharmony.pho.query.criterion.Restrictions;
import com.google.common.collect.Lists;
import com.sicdlib.dao.hbaseDAO.IPostDAO;
import com.sicdlib.util.EntityUtil.EntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDAO")
public class PostDAO implements IPostDAO {
    @Autowired
    DataStoreApi dataStoreApi;

    @Autowired
    @Qualifier("entityInfo")
    EntityInfo entityInfo;

    @Override
    public int getAllPostNum(String tableName) {
        return 0;
    }

    @Override
    public List getPostList(String tableName,String condition,String conditionValue) {
        try {
            String name = entityInfo.getEntityInfo(tableName);
            Class<?> TBTableEntityType =Class.forName("com.sicdlib.dto.phoenixEntity."+name);
            return Lists.newArrayList(dataStoreApi.findAll(QueryBuilder
                    .builderFor(TBTableEntityType)
                    .add(Restrictions.eq("\""+condition+"\"", conditionValue))
                    .select().build()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object getPostInfo(String condition, String tableName, String conditionValue) {
        try {
            String name = entityInfo.getEntityInfo(tableName);
            Class<?> TBTableEntityType =Class.forName("com.sicdlib.dto.phoenixEntity."+name);
            return dataStoreApi.findOne(QueryBuilder
                    .builderFor(TBTableEntityType)
                    .add(Restrictions.eq("\""+condition+"\"", conditionValue))
                    .select().build());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List getMoePostList(String tableName, String newsEditor) {
        try {
            String name = entityInfo.getEntityInfo(tableName);
            Class<?> TBTableEntityType = Class.forName("com.sicdlib.dto.phoenixEntity." + name);
            return Lists.newArrayList(dataStoreApi.findAll(QueryBuilder
                    .builderFor(TBTableEntityType)
                    .add(Restrictions.eq("\"news_editor\"", newsEditor))
//                    .addOrder(Ordering.desc("\"news_time\""))
                    .select().setReturnFields("distinct"+" "+"\"news_title\"").build()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object getMoePostInfo(String newsTitle, String tableName) {
        try {
            String name = entityInfo.getEntityInfo(tableName);
            Class<?> TBTableEntityType =Class.forName("com.sicdlib.dto.phoenixEntity."+name);
            return dataStoreApi.findOne(QueryBuilder
                    .builderFor(TBTableEntityType)
                    .add(Restrictions.eq("\"news_title\"", newsTitle))
                    .select().build());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
