package com.sicdlib.dao.hbaseDAO.imple;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Restrictions;
import com.google.common.collect.Lists;
import com.sicdlib.dao.hbaseDAO.ICommentDAO;
import com.sicdlib.dto.phoenixEntity.BBSChinaCommentEntity;
import com.sicdlib.dto.phoenixEntity.BBSChinaPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDAO")
public class CommentDAO implements ICommentDAO{

    @Autowired
    DataStoreApi dataStoreApi;

    @Override
    public List getCommentList(String tableName, String postID) {
        final QuerySelect<BBSChinaCommentEntity, BBSChinaCommentEntity> query = QueryBuilder
                .builderFor(BBSChinaCommentEntity.class)
                .add(Restrictions.eq("\"post_id\"", postID))
                .select().build();
        Iterable<BBSChinaCommentEntity> infoItems = dataStoreApi.findAll(query);
        System.out.println(infoItems.iterator().toString());
        return Lists.newArrayList(infoItems);
    }
}
