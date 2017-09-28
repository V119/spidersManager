package com.sicdlib.dao.hbaseDAO.imple;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Restrictions;
import com.google.common.collect.Lists;
import com.sicdlib.dao.hbaseDAO.ICommentDAO;
import com.sicdlib.dto.phoenixEntity.BBSChinaCommentEntity;
import com.sicdlib.dto.phoenixEntity.BBSChinaPostEntity;
import com.sicdlib.util.EntityUtil.EntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDAO")
public class CommentDAO implements ICommentDAO{

    @Autowired
    DataStoreApi dataStoreApi;

    @Autowired
    @Qualifier("entityInfo")
    EntityInfo entityInfo;

    @Override
    public List getCommentList(String tableName, String condition,String conditionValue) {

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
}
