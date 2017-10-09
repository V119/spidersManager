package com.sicdlib.dao.imple;

import com.sicdlib.dao.IAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ITableColumnDAO;
import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.util.PageUtil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("authorsDAO")
public class AuthorDAO implements IAuthorDAO {
    @Autowired
    @Qualifier("tableColumnDAO")
    private ITableColumnDAO tableColumnDAO;

    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;

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

    @Override
    public List<Object[]> getAuthorList(String tableName) {
        return null;
    }

    @Override
    public Object[] getAuthorInfo(String authorId, String tableName) {
        return new Object[0];
    }
}
