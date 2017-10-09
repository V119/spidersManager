package com.sicdlib.util.TableUtil;

import org.junit.Test;

/**
 * Created by YH on 2017/6/16.
 */
public class ArticleAuthorTableMapping {
    /**
     * 将文章表转换为和该表对应的作者表
     * 如果以_post结尾，则将_post替换为_author
     * 如果不以_post结尾，则返回该表本身
     * @param articleTable 文章表的表名
     * @return 对应的作者表的表名
     */
    public static String getAuthorTable(String articleTable) {
        if(articleTable.toLowerCase().endsWith("_post")) {
            return articleTable.substring(0, articleTable.length() - 5) + "_author";
        }
        System.out.println(articleTable.substring(0, articleTable.length() - 5) + "_author");
        return articleTable;
    }

}
