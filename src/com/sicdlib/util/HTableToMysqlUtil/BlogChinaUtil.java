package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.imple.BLOGChinaAuthorService;
import com.sicdlib.service.pythonService.imple.BLOGChinaBlogService;
import com.sicdlib.service.pythonService.imple.BLOGChinaCommentService;
import com.sicdlib.util.HBaseUtil.HBaseData;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 博客中国
 * Created by init on 2017/6/27.
 */
public class BlogChinaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 博客中国社区htable_作者转换到Mysql中
     */
    @Test
    public void test_blogChinaAuthor_HTableToMysql() throws Exception{
        BLOGChinaAuthorService blogChinaAuthorService = (BLOGChinaAuthorService) apx.getBean("blogChinaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         *博客中国
         */
        //博客中国 - 作者
        String htable_name = "blogchina_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
            BlogchinaAuthorEntity blogchinaAuthor = new BlogchinaAuthorEntity();
            i++;
            for (KeyValue rowKV : result.raw()) {
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值：字段对应的值
                String value = new String(rowKV.getValue());
                //将4字节表情或特殊字符去掉
                value = value.replaceAll("[\\x{10000}-\\x{10FFFF}]", "");
                value = value.replaceAll("<dd>","");
                value = value.replaceAll("</dd>","");
                Long time = new Long(rowKV.getTimestamp());
                blogchinaAuthor.setTimeStamp(new Timestamp(time));
                switch (qualifer){
                    case "author_id":
                        blogchinaAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        blogchinaAuthor.setAuthorName(value);
                        break;
                    case "author_blog_name":
                        blogchinaAuthor.setAuthorBlogName(value);
                        break;
                    case "introduce":
                        blogchinaAuthor.setIntroduce(value);
                        break;
                    case "image_url":
                        blogchinaAuthor.setImageUrl(value);
                        break;
                    case "article_num":
                        blogchinaAuthor.setArticleNum(Integer.parseInt(value));
                        break;
                    case "read_num":
                        blogchinaAuthor.setReadNum(Integer.parseInt(value));
                        break;
                    case "focuse_num":
                        blogchinaAuthor.setFocuseNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        blogchinaAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case  "all_article_url":
                        blogchinaAuthor.setAllArticleUrl(value);
                        break;
                }

            }
           blogChinaAuthorService.saveBLOGChinaAuthor(blogchinaAuthor);
            //每隔100条打印一下时间
            if (i % 100 == 0){
                int k = i/100;
                Long end100Time = new Date().getTime();
                Long end100toBeginTime = (end100Time - beginTime) / 1000;
                System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime+"秒");
            }
        }
        Long endTime = new Date().getTime();
        Long EndtoBeginTime = (endTime - beginTime) % 1000;
        System.out.println("运行到结束所需：\t" + EndtoBeginTime + "秒");
    }

    /**
     * 博客中国的评论信息转换到mysql中
     */
    @Test
    public  void test_blogChinaComment_HTableMysql() throws  Exception{
        BLOGChinaCommentService blogChinaCommentService = (BLOGChinaCommentService) apx.getBean("blogChinaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 博客中国
         */
        //评论
        String htable_name = "blogchina_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            BlogchinaCommentEntity blogchinaComment = new BlogchinaCommentEntity();
            i++;
            for(KeyValue rowKV : result.raw()){
                //字段名
                String qualifer = new String(rowKV.getQualifier());
                //值，字段对应的值
                String value = new String(rowKV.getValue());
                //数据公共清理
                value = CleanPublicUtil.publicCleanMethods(value);
                switch (qualifer){
                    case "comment_id":
                        blogchinaComment.setCommentId(value);
                        break;
                    case  "comment_blog_id":
                        blogchinaComment.setBlogId(value);
                        break;
                    case  "comment_user_id":
                        blogchinaComment.setAuthorId(value);
                        break;
                    case  "comment_time":
                        blogchinaComment.setDateTime(value);
                        break;
                    case  "praise_num":
                        blogchinaComment.setPraiseNum(Integer.parseInt(value));
                        break;
                    case  "replay_id":
                        blogchinaComment.setReplayId(value);
                        break;
                    case  "comment_content":
                        blogchinaComment.setContent(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blogchinaComment.setTimeStamp(new Timestamp(time));

            }
           blogChinaCommentService.saveBLOGChinaComment(blogchinaComment);
            //每隔100条打印一下时间
            if (i % 100 == 0){
                int k = i/100;
                Long end100Time = new Date().getTime();
                Long end100toBeginTime = (end100Time - beginTime) / 1000;
                System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime+"秒");
            }
        }
        Long endTime = new Date().getTime();
        Long EndtoBeginTime = (endTime - beginTime) % 1000;
        System.out.println("运行到结束所需：\t" + EndtoBeginTime + "秒");

    }


    /**
     * 博客中国的文章信息转换到mysql中
     */
    @Test
    public  void test_blogChinaBlog_HTableMysql() throws  Exception{
        BLOGChinaBlogService blogChinaBlogService = (BLOGChinaBlogService) apx.getBean("blogChinaBlogService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //文章
        String htable_name = "blogchina_blog";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            BlogchinaBlogEntity blogchinaBlog = new BlogchinaBlogEntity();
            i++;
            for(KeyValue rowKV : result.raw()){
                //字段名
                String qualifer = new String(rowKV.getQualifier(), Charset.forName("utf-8"));
                //值，字段对应的值
                String value = new String(rowKV.getValue());
                //数据公共清理
                value = CleanPublicUtil.publicCleanMethods(value);
                switch (qualifer){
                    case "blog_id":
                        blogchinaBlog.setBlogId(value);
                        break;
                    case  "author_id":
                        blogchinaBlog.setAuthorId(value);
                        break;
                    case "title":
                        blogchinaBlog.setTitle(value);
                        break;
                    case  "publish_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy.MM.ddhh:mm");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:00");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        blogchinaBlog.setDateTime(dateTime);
                        break;
                    case  "category":
                        blogchinaBlog.setCategory(value);
                        break;
                    case  "read_num":
                        blogchinaBlog.setReadNum(Integer.parseInt(value));
                        break;
                    case  "comment_num":
                        blogchinaBlog.setCommentNum(Integer.parseInt(value));
                        break;
                    case  "hand_up_num":
                        blogchinaBlog.setHandUpNum(Integer.parseInt(value));
                        break;
                    case  "hand_down_num":
                        blogchinaBlog.setHandDownNum(Integer.parseInt(value));
                        break;
                    case   "content":
                        blogchinaBlog.setContent(value);
                        break;
                    case   "url":
                        blogchinaBlog.setUrl(value);
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                blogchinaBlog.setTimeStamp(new Timestamp(time));
            }
           blogChinaBlogService.saveBLOGChinaBlog(blogchinaBlog);
            //每隔100条打印一下时间
            if (i % 100 == 0){
                int k = i/100;
                Long end100Time = new Date().getTime();
                Long end100toBeginTime = (end100Time - beginTime) / 1000;
                System.out.println("运行到第" + k + "百条所需：\t" + end100toBeginTime+"秒");
            }
        }
        Long endTime = new Date().getTime();
        Long EndtoBeginTime = (endTime - beginTime) % 1000;
        System.out.println("运行到结束所需：\t" + EndtoBeginTime + "秒");

    }

}
