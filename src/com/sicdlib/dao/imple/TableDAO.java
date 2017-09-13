package com.sicdlib.dao.imple;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ITableDAO;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.TbTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("tableDAO")
public class TableDAO implements ITableDAO {
    @Autowired
    private IBaseDAO baseDAO;

    @Override
    public Boolean saveOrUpdateTable(TbTableEntity table) {
        try{
            baseDAO.saveOrUpdate(table);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TbTableEntity getTable(String name) {
        String hql = "from TbTableEntity tb where tb.tableName = '"+name+"'";
        return (TbTableEntity) baseDAO.get(hql);
    }

    @Override
    public List<TbTableEntity> getTableByEventID(String eventID) {
        String hql = "FROM TbTableEntity table " +
                "WHERE table.id in " +
                "(" +
                "SELECT distinct articleNum.table.id " +
                "FROM TbEventArticleEntity articleNum " +
                "WHERE articleNum.event.id = '" + eventID + "'" +
                ")";

        return baseDAO.find(hql);
    }

    @Override
    public List<String> getArticleContent(String eventID, String tableID, String tableName) {
        String sql = "select articleTable.content " +
                "FROM " + tableName + " articleTable " +
                "WHERE articleTable.id in " +
                "(" +
                "SELECT ea.source_article_id " +
                "FROM tb_event_article ea " +
                "WHERE ea.event_id = '" + eventID + "' AND ea.table_id = '" + tableID + "' " +
                ")";
        return baseDAO.getSqlList(sql);
    }

    @Override
    public List<String[]> getArticleIdAndContent(String eventID, String tableID, String tableName) {
        String sql = "select s.id, articleTable.content " +
                "FROM " + tableName + " articleTable, " +
                "(" +
                "SELECT ea.ID, ea.source_article_id " +
                "FROM tb_event_article ea " +
                "WHERE ea.event_id = '" + eventID + "' AND ea.table_id = '" + tableID + "' " +
                ") s " +
                "WHERE articleTable.id = s.source_article_id";
        return baseDAO.getSqlList(sql);
    }

    @Override
    public String getArticleContent(String articleID, String tableName) {
        String sql = "SELECT tb.content " +
                "FROM " + tableName + " tb " +
                "WHERE tb.id = '" + articleID + "'";

        return (String) baseDAO.getSqlList(sql).get(0);
    }

    @Override
    public Map<String,Integer> getCommentNumByTableName(String eventname ){
        System.out.println(eventname);
        String hql="From TbEventEntity tb_e where tb_e.eventName='"+eventname+"'";
        List<TbEventEntity> tbelist=baseDAO.find(hql);
//        String hql1="From TbEventArticleEntity tb_e where tb_e.event.id='"+tbelist.get(0).getId()+"'";
//        List<TbEventArticleEntity> tb_elist=baseDAO.find(hql1);
        Map<String,Integer> map=new HashMap<>();
        List<TbTableEntity> list1=getTableByEventID(tbelist.get(0).getId());
        for (TbTableEntity item:list1) {
            if(item.getTableName().contains("post")){
                String sqlnew="select sum(comment_num) from "+item.getTableName()+" where "+item.getTableName()+
                        ".id in (select distinct tb_event_article.source_article_id from tb_event_article  where tb_event_article.event_id='"
                        +tbelist.get(0).getId()+"')";
                System.out.println("表名:"+item.getTableName());
                BigDecimal a=baseDAO.getcount(sqlnew);
                System.out.println("----------" + a);
                map.put(item.getTableName(),a.intValue());
            }

        }
         System.out.println("*********************"+map.get("douban_group_post"));
         return  map;
    }
    //网民参与度
    @Override
    public List<String[]> getActiveness(String eventID) {
       String sql = "select activeness from tb_author";
       return baseDAO.getSqlList(sql);
    }
}