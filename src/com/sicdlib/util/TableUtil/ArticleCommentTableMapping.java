package com.sicdlib.util.TableUtil;

import com.sicdlib.dao.ITableColumnDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by YH on 2017/6/18.
 */
public class ArticleCommentTableMapping {
    /**
     * 根据文章表查找相应的评论表
     * @param postTableName 文章表表名
     * @return 评论表名，不存在则返回null
     */
    public static String getCommentTable(String postTableName) {
        if(postTableName.toLowerCase().endsWith("_post")) {
            return postTableName.substring(0, postTableName.length() - 5) + "_comment";
        }
        return null;
    }
}
