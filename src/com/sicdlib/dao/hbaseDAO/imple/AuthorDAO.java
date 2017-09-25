package com.sicdlib.dao.hbaseDAO.imple;

import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Criterion;
import com.eharmony.pho.query.criterion.Ordering;
import com.eharmony.pho.query.criterion.Restrictions;
import com.google.common.collect.Lists;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ITableColumnDAO;
import com.sicdlib.dao.hbaseDAO.IAuthorDAO;
import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.phoenixEntity.*;
import com.sicdlib.util.EntityUtil.EntityInfo;
import com.sicdlib.util.HBaseUtil.HBPage;
import com.sicdlib.util.HBaseUtil.HBaseData;
import javassist.runtime.Desc;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sicdlib.support.Page.DESC;


@Repository("authorDAO")
public class AuthorDAO implements IAuthorDAO {

    @Autowired
    DataStoreApi dataStoreApi;

    @Autowired
    @Qualifier("tableColumnDAO")
    private ITableColumnDAO tableColumnDAO;

    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

    @Autowired
    @Qualifier("entityInfo")
    EntityInfo entityInfo;

    @Override
    public List<Object[]> getAuthorIdAndNameAndFansNumWithPost(String eventID, String tableID, String postTableName, String authorTableName)
            throws Exception {
        if(postTableName.equals(authorTableName)) {
            throw new Exception("post table name: " + postTableName +
                    ", author table name: " + authorTableName + " 表名必须不同");
        }

        String fans_num_field = "author.fans_num";
        //判断author 表中是否存在粉丝数属性
        if(!tableColumnDAO.isExistColumn(authorTableName, "fans_num")) {
            fans_num_field = "0";
        }

        String sql = "SELECT DISTINCT author.id, author.author_id, author.author_name, " + fans_num_field + " " +
                "FROM " + authorTableName + " author, " +
                "(" +
                "SELECT post.author_id, h.time " +
                "FROM " + postTableName + " post," +
                " (" +
                "SELECT event.source_article_id, event.time " +
                "FROM tb_event_article event " +
                "WHERE event.event_id = '" + eventID + "' AND event.table_id = '" + tableID + "' " +
                ") h " +
                "WHERE post.id = h.source_article_id " +
                ") s "+
                "WHERE author.author_id = s.author_id";

        return baseDAO.getSqlList(sql);
    }

    @Override
    public List<Object[]> getAuthorNameWithNonePost(String eventID, String tableID, String articleTableName) throws Exception {
        if (articleTableName.toLowerCase().endsWith("_post")) {
            throw new Exception("table name: " + articleTableName + "， 表名不对");
        }
        String fans_num_field = "author.fans_num";
        //判断author 表中是否存在粉丝数属性
        if(!tableColumnDAO.isExistColumn(articleTableName, "fans_num")) {
            fans_num_field = "0";
        }

        String sql = "SELECT DISTINCT h.source_article_id, table.author, " + fans_num_field + " " +
                "FROM " + articleTableName + " table," +
                " (" +
                "SELECT event.source_article_id, event.time " +
                "FROM tb_event_article event " +
                "WHERE event.event_id = '" + eventID + "' AND event.table_id = '" + tableID + "' " +
                ") h " +
                "WHERE table.id = h.source_article_id ";

        return baseDAO.getSqlList(sql);
    }

    @Override
    public Object[] getAuthorReadArticleReplyNumInAuthorTable(String authorID, String tableName) {
        //是否存在浏览量字段、回复数字段、粉丝数字段，如果不存在，以0代替
        String commentNumField = "0";
        if (tableColumnDAO.isExistColumn(tableName,"comment_num")) {
            commentNumField = "tb.comment_num";
        } else if(tableColumnDAO.isExistColumn(tableName, "reply_num")) {
            commentNumField = "tb.reply_num";
        }

        String readNumField = "0";
        if (tableColumnDAO.isExistColumn(tableName, "read_num")) {
            readNumField = "read_num";
        }

        String sql = "SELECT COUNT(*), SUM(" + commentNumField + "), SUM(" + readNumField + ") " +
                "FROM " + tableName + " tb " +
                "WHERE tb.author_id = '" + authorID + "'";

        List<Object[]> resultList = baseDAO.getSqlList(sql);

        return resultList != null && resultList.size() > 0 ? resultList.get(0) : new Object[]{0, 0, 0};
    }

    @Override
    public Object[] getAuthorReadArticleReplyNumInPostTable(String authorName, String tableName) {
        //是否存在浏览量字段、回复数字段、粉丝数字段，如果不存在，以0代替
        String commentNumField = "0";
        if (tableColumnDAO.isExistColumn(tableName,"comment_num")) {
            commentNumField = "tb.comment_num";
        } else if(tableColumnDAO.isExistColumn(tableName, "reply_num")) {
            commentNumField = "tb.reply_num";
        }

        String readNumField = "0";
        if (tableColumnDAO.isExistColumn(tableName, "read_num")) {
            readNumField = "read_num";
        }

        String sql = "SELECT COUNT(*), SUM(" + commentNumField + "), SUM(" + readNumField + ") " +
                "FROM " + tableName + " tb " +
                "WHERE tb.author = '" + authorName + "'";

        List<Object[]> resultList = baseDAO.getSqlList(sql);

        return resultList != null && resultList.size() > 0 ? resultList.get(0) : new Object[]{0, 0, 0};
    }

    @Override
    public void saveAuthorEntity(TbAuthorEntity authorEntity) {
        baseDAO.save(authorEntity);
    }

    @Override
    public void saveEventAuthorMapping(TbEventAuthorMappingEntity eventAuthor) {
        baseDAO.save(eventAuthor);
    }

    @Override
    public void saveEventAuthorMapping(TbEventAuthorMappingEntity eventAuthor, String eventID) {
        TbEventEntity event = (TbEventEntity) baseDAO.get(TbEventEntity.class, eventID);
        eventAuthor.setEvent(event);

        baseDAO.save(eventAuthor);
    }

    @Override
    public List<TbEventAuthorMappingEntity> getEventAuthorMappingByEventId(String eventID) {
        String hql = "FROM TbEventAuthorMappingEntity eventAuthor " +
                "WHERE eventAuthor.event.id = '" + eventID + "'";
        return baseDAO.find(hql);
    }

    @Override
    public int getAllAuthorNum(String tableName) {

        return 0;
    }

    /*@Override
    public List<Object[]> getAuthorList(String tableName,HBPage page) {
        HBaseData inf = null;
        List listInfo = new ArrayList<>();
        try {
            inf = new HBaseData(tableName);
            List list = new ArrayList<>();
            page.setPageStartRowKey(inf.getStartRow());
            if (page.getPageIndex()==1){
                page.setPageStartRowKey(inf.getStartRow());
                list = inf.getFirstPage(page);
            }
            if (page.getPrePage()==0){
                list = inf.getPrePage(page);
            }
            if (page.getNextPage()==0){
                list = inf.getNext(page);
            }

            for (int i = 0;i < list.size(); i++){
                Result result = (Result) list.get(i);
                if ("bbs_china_author".equals(tableName)){
                    BBSChinaAuthorEntity bschina = new BBSChinaAuthorEntity();
                    for (KeyValue keyValue : result.list()){
                        String qualifier = new String(keyValue.getQualifier(), "utf-8");
                        String value = new String(keyValue.getValue(), "utf-8");

                        if("address".equals(qualifier)){
                            bschina.setAddress(value);
                        }
                        if ("author_id".equals(qualifier)){
                            bschina.setAuthorID(value);
                        }
                        if ("author_name".equals(qualifier)){
                            bschina.setAuthorName(value);
                        }
                        if ("birthday".equals(qualifier)){
                            bschina.setBirthday(value);
                        }
                        if ("fans_num".equals(qualifier)){
                            bschina.setFansNum(value);
                        }
                        if ("focuse_num".equals(qualifier)){
                            bschina.setFocuseNum(value);
                        }
                        if ("name".equals(qualifier)){
                            bschina.setName(value);
                        }
                        if ("parse_time".equals(qualifier)){
                            bschina.setParseTime(value);
                        }
                        if ("sex".equals(qualifier)){
                            bschina.setSex(value);
                        }
                        if ("url".equals(qualifier)){
                            bschina.setAddress(value);
                        }
                        System.out.println("list中 列："+qualifier+":"+value);
                    }
                    listInfo.add(bschina);
                }
                if ("bbs_mop_author".equals(tableName)){
                    BBSMopAuthorEntity bsMop = new BBSMopAuthorEntity();
                    for (KeyValue keyValue : result.list()) {
                        String qualifier = new String(keyValue.getQualifier(), "utf-8");
                        String value = new String(keyValue.getValue(), "utf-8");
                        if ("author_id".equals(qualifier)){
                            bsMop.setAuthorID(value);
                        }
                        if ("author_name".equals(qualifier)){
                            bsMop.setAuthorName(value);
                        }
                        if ("age".equals(qualifier)){
                            bsMop.setAge(value);
                        }
                        if ("birthday".equals(qualifier)){
                            bsMop.setBirthday(value);
                        }
                        if ("career".equals(qualifier)){
                            bsMop.setCareer(value);
                        }
                        if ("contact_way".equals(qualifier)){
                            bsMop.setContactWay(value);
                        }
                        if ("education".equals(qualifier)){
                            bsMop.setEducation(value);
                        }
                        if ("fans_num".equals(qualifier)){
                            bsMop.setFansNum(value);
                        }
                        if ("friends_num".equals(qualifier)){
                            bsMop.setFriends_num(value);
                        }
                        if ("hits".equals(qualifier)){
                            bsMop.setHits(value);
                        }
                        if ("introduce".equals(qualifier)){
                            bsMop.setIntroduce(value);
                        }
                        if ("league".equals(qualifier)){
                            bsMop.setLeague(value);
                        }
                        if ("level".equals(qualifier)){
                            bsMop.setLevel(value);
                        }
                        if ("level_nick".equals(qualifier)){
                            bsMop.setLevelNick(value);
                        }
                        if ("login_num".equals(qualifier)){
                            bsMop.setLoginNum(value);
                        }
                        if ("post_num".equals(qualifier)){
                            bsMop.setPostNum(value);
                        }
                        if ("register_date".equals(qualifier)){
                            bsMop.setRegisterDate(value);
                        }
                        if ("reply_num".equals(qualifier)){
                            bsMop.setReplyNum(value);
                        }
                        if ("sex".equals(qualifier)){
                            bsMop.setSex(value);
                        }
                        if ("url".equals(qualifier)){
                            bsMop.setUrl(value);
                        }
                        listInfo.add(bsMop);
                    }

                }

                if ("bbs_people_author".equals(tableName)){
                    BBSPeopleAuthorEntity bbsPeople = new BBSPeopleAuthorEntity();
                    for (KeyValue keyValue : result.list()) {
                        String qualifier = new String(keyValue.getQualifier(), "utf-8");
                        String value = new String(keyValue.getValue(), "utf-8");
                        if ("author_id".equals(qualifier)) {
                            bbsPeople.setAuthorID(value);
                        }
                        if ("author_name".equals(qualifier)) {
                            bbsPeople.setAuthorName(value);
                        }
                        if ("elite_num".equals(qualifier)) {
                            bbsPeople.setEliteNum(value);
                        }
                        if ("level".equals(qualifier)) {
                            bbsPeople.setLevel(value);
                        }
                        if ("post_num".equals(qualifier)) {
                            bbsPeople.setPostNum(value);
                        }
                        if ("reply_num".equals(qualifier)) {
                            bbsPeople.setReplyNum(value);
                        }
                        if ("url".equals(qualifier)) {
                            bbsPeople.setUrl(value);
                        }
                        if ("age".equals(qualifier)) {
                            bbsPeople.setAge(value);
                        }
                        listInfo.add(bbsPeople);
                    }
                }

                if ("bbs_sohu_author".equals(tableName)){
                    BBSSohuAuthorEntity bbsSohu = new BBSSohuAuthorEntity();
                    for (KeyValue keyValue : result.list()) {
                        String qualifier = new String(keyValue.getQualifier(), "utf-8");
                        String value = new String(keyValue.getValue(), "utf-8");
                        if ("author_id".equals(qualifier)) {
                            bbsSohu.setAuthorID(value);
                        }
                        if ("fans_num".equals(qualifier)){
                            bbsSohu.setFansNum(value);
                        }
                        if ("friends_num".equals(qualifier)){
                            bbsSohu.setFriendsNum(value);
                        }
                        if ("introduction".equals(qualifier)){
                            bbsSohu.setIntroduction(value);
                        }
                        if ("nick_name".equals(qualifier)){
                            bbsSohu.setNickName(value);
                        }
                        if ("parse_time".equals(qualifier)){
                            bbsSohu.setParseTime(value);
                        }
                        if ("sex".equals(qualifier)){
                            bbsSohu.setParseTime(value);
                        }
                        if ("birthday".equals(qualifier)){
                            bbsSohu.setBirthday(value);
                        }
                        if ("level".equals(qualifier)){
                            bbsSohu.setLevel(value);
                        }
                        if ("post_num".equals(qualifier)){
                            bbsSohu.setPostNum(value);
                        }
                        if ("login_num".equals(qualifier)){
                            bbsSohu.setLoginNum(value);
                        }
                        if ("education".equals(qualifier)){
                            bbsSohu.setEducation(value);
                        }
                        if ("title".equals(qualifier)){
                            bbsSohu.setTitle(value);
                        }
                        if ("duty".equals(qualifier)){
                            bbsSohu.setDuty(value);
                        }
                        if ("elite_num".equals(qualifier)){
                            bbsSohu.setEliteNum(value);
                        }
                        if ("point".equals(qualifier)){
                            bbsSohu.setPoint(value);
                        }
                        if ("online_time".equals(qualifier)){
                            bbsSohu.setOnlineTime(value);
                        }
                        if ("reputation".equals(qualifier)){
                            bbsSohu.setReputation(value);
                        }
                        if ("last_login".equals(qualifier)){
                            bbsSohu.setLastLogin(value);
                        }
                        if ("sport".equals(qualifier)){
                            bbsSohu.setSport(value);
                        }
                        if ("movie".equals(qualifier)){
                            bbsSohu.setMovie(value);
                        }
                        if ("music".equals(qualifier)){
                            bbsSohu.setMusic(value);
                        }
                        if ("food".equals(qualifier)){
                            bbsSohu.setFood(value);
                        }
                        if ("book".equals(qualifier)){
                            bbsSohu.setBook(value);
                        }
                        if ("person".equals(qualifier)){
                            bbsSohu.setPerson(value);
                        }
                        if ("profession".equals(qualifier)){
                            bbsSohu.setProfession(value);
                        }
                        listInfo.add(bbsSohu);
                    }

                }

                if ("bbs_tianya_author".equals(tableName)){
                    BBSTianyaAuthorEntity bbsTianya = new BBSTianyaAuthorEntity();
                    for (KeyValue keyValue : result.list()) {
                        String qualifier = new String(keyValue.getQualifier(), "utf-8");
                        String value = new String(keyValue.getValue(), "utf-8");
                        if ("author_id".equals(qualifier)) {
                            bbsTianya.setAuthorID(value);
                        }
                        if ("fans_num".equals(qualifier)) {
                            bbsTianya.setFansNum(value);
                        }
                        if ("author_name".equals(qualifier)) {
                            bbsTianya.setAuthorName(value);
                        }
                        if ("friends_num".equals(qualifier)) {
                            bbsTianya.setFriendsNum(value);
                        }
                        if ("level".equals(qualifier)) {
                            bbsTianya.setLevel(value);
                        }
                        if ("location".equals(qualifier)) {
                            bbsTianya.setLocation(value);
                        }
                        if ("login_num".equals(qualifier)) {
                            bbsTianya.setLoginNum(value);
                        }
                        if ("point".equals(qualifier)) {
                            bbsTianya.setPoint(value);
                        }
                        if ("register_date".equals(qualifier)) {
                            bbsTianya.setRegisterDate(value);
                        }
                        if ("url".equals(qualifier)) {
                            bbsTianya.setUrl(value);
                        }
                        if ("online_time".equals(qualifier)) {
                            bbsTianya.setOnlineTime(value);
                        }

                        listInfo.add(bbsTianya);
                    }
                }
                if ("kdnet_author".equals(tableName)){
                    KdnetAuthorEntity kdAuthor = new KdnetAuthorEntity();
                    for (KeyValue keyValue : result.list()) {
                        String qualifier = new String(keyValue.getQualifier(), "utf-8");
                        String value = new String(keyValue.getValue(), "utf-8");
                        if ("author_id".equals(qualifier)) {
                            kdAuthor.setAuthorID(value);
                        }
                        if ("fans_num".equals(qualifier)) {
                            kdAuthor.setFansNum(value);
                        }
                        if ("friends_num".equals(qualifier)) {
                            kdAuthor.setFriendsNum(value);
                        }
                        if ("hits".equals(qualifier)) {
                            kdAuthor.setHits(value);
                        }
                        if ("influence".equals(qualifier)) {
                            kdAuthor.setInfluence(value);
                        }
                        if ("level".equals(qualifier)) {
                            kdAuthor.setLevel(value);
                        }
                        if ("login_num".equals(qualifier)) {
                            kdAuthor.setLoginNum(value);
                        }
                        if ("nick".equals(qualifier)) {
                            kdAuthor.setNick(value);
                        }
                        if ("parse_time".equals(qualifier)) {
                            kdAuthor.setParseTime(value);
                        }
                        if ("post_num".equals(qualifier)) {
                            kdAuthor.setPostNum(value);
                        }
                        if ("register_time".equals(qualifier)) {
                            kdAuthor.setRegisterNum(value);
                        }
                        if ("url".equals(qualifier)) {
                            kdAuthor.setUrl(value);
                        }

                        listInfo.add(kdAuthor);
                    }

                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return listInfo;
    }*/

    @Override
    public Object getAuthorInfo(String authorID, String tableName) {
        final QuerySelect<BBSChinaAuthorEntity, BBSChinaAuthorEntity> query = QueryBuilder
                .builderFor(BBSChinaAuthorEntity.class)
                .add(Restrictions.eq("\"author_id\"", authorID))
                .select().build();
        BBSChinaAuthorEntity infoItems = dataStoreApi.findOne(query);
        System.out.println(infoItems.toString());

        return  infoItems;
    }

    @Override
    public List getAuthorList(String tableName,HBPage page){

        final QuerySelect<BBSChinaAuthorEntity, BBSChinaAuthorEntity> query = QueryBuilder
                .builderFor(BBSChinaAuthorEntity.class)
                .setMaxResults(page.getPageSize())
                .select().build();
        System.out.println(query);
        Iterable<BBSChinaAuthorEntity> infoItems = dataStoreApi.findAll(query);

        return Lists.newArrayList(infoItems);
    }
    @Override
    public List getAuthorList(String tableName,HBPage page,String rowKeyEndNum,String rowKeyBeginNum){

        List list = new ArrayList();

        if (page.getPrePage()==0){//查询上一页
            final QuerySelect<BBSChinaAuthorEntity, BBSChinaAuthorEntity> query = QueryBuilder
                    .builderFor(BBSChinaAuthorEntity.class)
                    .add(Restrictions.and(Restrictions.lt("\"PK\"", page.getRowKeyBeginNum())))
                    .addOrder(Ordering.desc("\"PK\""))
                    .setMaxResults(page.getPageSize())
                    .select().build();
            System.out.println(query);
            Iterable<BBSChinaAuthorEntity> infoItems = dataStoreApi.findAll(query);
            list = Lists.newArrayList(infoItems);
        }else if (page.getNextPage()==0){//查询下一页
            final QuerySelect<BBSChinaAuthorEntity, BBSChinaAuthorEntity> query = QueryBuilder
                    .builderFor(BBSChinaAuthorEntity.class)
                    .add(Restrictions.and(Restrictions.gt("\"PK\"",page.getRowKeyEndNum())))
                    .setMaxResults(page.getPageSize())
                    .select().build();
            System.out.println(query);
            Iterable<BBSChinaAuthorEntity> infoItems = dataStoreApi.findAll(query);
            list = Lists.newArrayList(infoItems);
        }

        return list;
    }


}
