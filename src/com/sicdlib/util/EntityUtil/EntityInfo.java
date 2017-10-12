package com.sicdlib.util.EntityUtil;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Restrictions;
import com.sicdlib.dto.phoenixEntity.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository("entityInfo")
public class EntityInfo {

    @Autowired
    DataStoreApi dataStoreApi;

    TbTableEntity tbTableEntity;
    public String getEntityInfo(String tableName) {
        final QuerySelect<TbTableEntity, TbTableEntity> query = QueryBuilder
                .builderFor(TbTableEntity.class)
                .add(Restrictions.eq("\"table_name\"", tableName))
                .select().build();
        tbTableEntity = dataStoreApi.findOne(query);
        return  tbTableEntity.getEntityName();
    }
}
