package com.sicdlab.phoenix;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.hbase.PhoenixHBaseDataStoreApiImpl;
import com.eharmony.pho.hbase.mapper.PhoenixProjectedResultMapper;
import com.eharmony.pho.hbase.query.PhoenixHBaseQueryExecutor;
import com.eharmony.pho.hbase.translator.PhoenixHBaseQueryTranslator;
import com.eharmony.pho.mapper.EntityPropertiesMappingContext;
import com.eharmony.pho.mapper.EntityPropertiesResolver;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.sicdlib.dto.phoenixEntity.SpiderInfoEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by haoyang on 2017/9/12.
 */
public class MainTest {
    /*@Test
    public void selectAll() throws Exception {
        final List<String> classesList = new ArrayList<String>();
        classesList.add("com.sicdlib.dto.phoenixEntity.SpiderInfoEntity");
        EntityPropertiesMappingContext context = new EntityPropertiesMappingContext(classesList);
        EntityPropertiesResolver entityPropertiesResolver = new EntityPropertiesResolver(context);
        PhoenixHBaseQueryTranslator translator = new PhoenixHBaseQueryTranslator(entityPropertiesResolver);
        PhoenixProjectedResultMapper mapper = new PhoenixProjectedResultMapper(entityPropertiesResolver);
        PhoenixHBaseQueryExecutor executor = new PhoenixHBaseQueryExecutor(translator, mapper);
        String connUrl = "jdbc:phoenix:192.168.100.201:2181";
        DataStoreApi dataStoreApi = new PhoenixHBaseDataStoreApiImpl(connUrl, executor);
        Date start = new Date();
        System.out.println(start);
        final QuerySelect query = QueryBuilder
                .builderFor(SpiderInfoEntity.class)
                .select().build();
        Iterable<SpiderInfoEntity> feedItems = dataStoreApi.findAll(query);
        Date endTime = new Date();
        System.out.println(endTime);
        System.out.println(endTime.getTime() - start.getTime());
        feedItems.forEach(spiderInfoEntity -> System.out.println(spiderInfoEntity.getPk()));
    }*/

//    @Test
//    public void selectWebStat() throws Exception {
//        final List<String> classesList = new ArrayList<>();
//        classesList.add("com.eharmony.pho.hbase.model.WebStatEntity");
//        EntityPropertiesMappingContext context = new EntityPropertiesMappingContext(classesList);
//        EntityPropertiesResolver entityPropertiesResolver = new EntityPropertiesResolver(context);
//        PhoenixHBaseQueryTranslator translator = new PhoenixHBaseQueryTranslator(entityPropertiesResolver);
//        PhoenixProjectedResultMapper mapper = new PhoenixProjectedResultMapper(entityPropertiesResolver);
//        PhoenixHBaseQueryExecutor executor = new PhoenixHBaseQueryExecutor(translator, mapper);
//        String connUrl = "jdbc:phoenix:192.168.100.201:2181";
//        DataStoreApi dataStoreApi = new PhoenixHBaseDataStoreApiImpl(connUrl, executor);
//        final QuerySelect query = QueryBuilder
//                .builderFor(WebStatEntity.class)
//                .select().build();
//        Iterable<WebStatEntity> feedItems = dataStoreApi.findAll(query);
//        feedItems.forEach(webStatEntity -> System.out.println(webStatEntity.getDate()));
//    }
        @Test
    public void selectWebStat() throws Exception {
        String a = "BBSChinaAuthorEntity{pk='001c0d917f7c91bdbb9620f9ee3f5de2', address='<dd></dd>', authorID='4215260', authorName=' whuedu
                ', birthday='<dd></dd>', fansNum='0', focuseNum='0', name='<dd></dd>', parseTime='1495307990.6213076', sex='<dd>其他</dd>', url='http://i.club.china.com/user/UserInfoAction.do?processID=myhome&userId=4215260'}"
    }
}
