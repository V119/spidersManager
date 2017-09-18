package com.sicdlib.dao.hbaseDAO.imple;

import com.google.common.collect.Lists;
import com.sicdlib.dao.hbaseDAO.ITest;
import com.sicdlib.dto.phoenixEntity.SpiderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Restrictions;

import java.util.List;

/**
 * Created by haoyang on 2017/9/18.
 * API参见 https://github.com/eHarmony/pho#query-execution
 */
@Repository("hbaseTest")
public class HbaseTest implements ITest {
    @Autowired
    DataStoreApi dataStoreApi;

    @Override
    public List<SpiderInfoEntity> getTestEntity() {
            final QuerySelect<SpiderInfoEntity, SpiderInfoEntity> query = QueryBuilder
                        .builderFor(SpiderInfoEntity.class)
                        .select().build();
            Iterable<SpiderInfoEntity> infoItems = dataStoreApi.findAll(query);

            return Lists.newArrayList(infoItems);
    }
}


//@Repository
//public class MatchStoreQueryRepositoryImpl implements MatchStoreQueryRepository {
//    final QuerySelect<MatchDataFeedItemDto, MatchDataFeedItemDto> query = QueryBuilder
//            .builderFor(MatchDataFeedItemDto.class)
//            .select()
//            .add(Restrictions.eq("userId", userId))
//            .add(Restrictions.eq("status", 2))
//            .add(Restrictions.gt("deliveredDate", timeThreshold.getTime())).build();
//    Iterable<MatchDataFeedItemDto> feedItems = dataStoreApi.findAll(query);

