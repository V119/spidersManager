package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.pythonService.IBBSChinaAuthorService;
import com.sicdlib.service.pythonService.IBBSChinaCommentService;
import com.sicdlib.service.pythonService.IBBSChinaPostService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by init on 2017/5/25.
 * 中华网社区
 */

public class BBSChinaUtil {
    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * 中华网社区htable_作者转换到Mysql中
     */
    @Test
    public void test_bbsChinaAuthor_HTableToMysql() throws Exception{
        IBBSChinaAuthorService bbsChinaAuthorService = (IBBSChinaAuthorService) apx.getBean("bbsChinaAuthorService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //中华网社区 - 作者
        String htable_name = "bbs_china_author";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for (Result result : results) {
           BbsChinaAuthorEntity bbsChinaAuthor = new BbsChinaAuthorEntity();
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
                bbsChinaAuthor.setTimeStamp(new Timestamp(time));
                switch (qualifer){
                    case "author_id":
                        bbsChinaAuthor.setAuthorId(value);
                        break;
                    case "author_name":
                        bbsChinaAuthor.setAuthorName(value);
                        break;
                    case "name":
                        bbsChinaAuthor.setName(value);
                        break;
                    case "sex":
                        bbsChinaAuthor.setSex(value);
                        break;
                    case "birthday":
                        bbsChinaAuthor.setBirthday(value);
                        break;
                    case "address":
                        bbsChinaAuthor.setAddress(value);
                        break;
                    case "focuse_num":
                        bbsChinaAuthor.setFocuseNum(Integer.parseInt(value));
                        break;
                    case "fans_num":
                        bbsChinaAuthor.setFansNum(Integer.parseInt(value));
                        break;
                    case  "url":
                        bbsChinaAuthor.setUrl(value);
                    case  "parse_time":
                        if(value.contains("http://i.club.china.com/user/UserInfoAction.do?processID=myhome&userId")){
                            bbsChinaAuthor.setParseTime(new Timestamp(time));
                        }else {
                            Double doubleTime = Double.parseDouble(value) * 1000;
                            Long longTime = new Long(doubleTime.longValue());
                            bbsChinaAuthor.setParseTime(new Timestamp(longTime));
                        }
                        break;
                }

            }
            bbsChinaAuthorService.saveBBSChinaAuthor(bbsChinaAuthor);
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
     * 中华网社区的评论信息转换到mysql中
     */
    @Test
    public  void test_bbsChinaComment_HTableMysql() throws  Exception{
        IBBSChinaCommentService bbsChinaCommentService = (IBBSChinaCommentService) apx.getBean("bbsChinaCommentService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //评论
        String htable_name = "bbs_china_comment";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            BbsChinaCommentEntity bbsChinaComment  = new BbsChinaCommentEntity();
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
                    bbsChinaComment.setCommentId(value);
                    break;
                case  "post_id":
                     bbsChinaComment.setPostId(value);
                     break;
                case  "author_id":
                     bbsChinaComment.setAuthorId(value);
                     break;
                case  "author_name":
                     bbsChinaComment.setAuthorName(value);
                     break;
                case  "prise_num":
                    bbsChinaComment.setPriseNum(Integer.parseInt(value));
                    break;
                case  "date_time":
                    String dateTime = "";
                    DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
                    DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    dateTime = destFormat.format(sourceFormat.parse(value));
                    bbsChinaComment.setDateTime(dateTime);
                    break;
                case  "floor":
                    bbsChinaComment.setFloor(value);
                    break;
                case  "content":
                    bbsChinaComment.setContent(value);
                    break;
            }
            Long time = new Long(rowKV.getTimestamp());
            bbsChinaComment.setTimeStamp(new Timestamp(time));

        }
            bbsChinaCommentService.saveBBSChinaComment(bbsChinaComment);
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
     * 中华网社区的文章信息转换到mysql中
     */
    @Test
    public  void test_bbsChinaPost_HTableMysql() throws  Exception{
        IBBSChinaPostService bbsChinaPostService = (IBBSChinaPostService) apx.getBean("bbsChinaPostService");
        Long beginTime = new Date().getTime();
        /**
         * 中华网社区
         */
        //文章
        String htable_name = "bbs_china_post";
        HBaseData hBaseData = new HBaseData(htable_name);
        ResultScanner results = hBaseData.getAllData();
        int i = 0;
        //输出结果
        for(Result result : results){
            BbsChinaPostEntity  bbsChinaPost = new BbsChinaPostEntity();
            i++;
            for(KeyValue rowKV : result.raw()){
                //字段名
                String qualifer = new String(rowKV.getQualifier(), Charset.forName("utf-8"));
                //值，字段对应的值
                String value = new String(rowKV.getValue());
                //数据公共清理
                value = CleanPublicUtil.publicCleanMethods(value);
                switch (qualifer){
                    case "post_id":
                        bbsChinaPost.setPostId(value);
                        break;
//                    case "comment_ids":
//                        List<String> listString = this.getCommentId(value);
//                        bbsChinaPost.setCommentNum(listString.size());
//                        break;
                    case  "author_id":
                        bbsChinaPost.setAuthorId(value);
                        break;
                    case  "path_text":
                        bbsChinaPost.setPathText(value);
                        break;
                    case  "path_href":
                        bbsChinaPost.setPathHref(value);
                        break;
                    case  "title":
                        bbsChinaPost.setTitle(value);
                        break;
                    case  "key_words":
                        bbsChinaPost.setKeyWords(value);
                        break;
                    case  "hot_words":
                        bbsChinaPost.setHotWords(value);
                        break;
                    case  "author_name":
                        bbsChinaPost.setAuthorName(value);
                        break;
                    case   "content":
                        bbsChinaPost.setContent(value);
                        break;
                    case   "level":
                        String contentValue = value.replaceAll("等级","");
                        if(contentValue == null || contentValue.equals("")) {
                            contentValue = "0";
                        }
                        bbsChinaPost.setLevel(contentValue);
                        break;
                    case   "point":
                        bbsChinaPost.setPoint(value);
                        break;
                    case  "date_time":
                        String dateTime = " ";
                        DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
                        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        dateTime = destFormat.format(sourceFormat.parse(value));
                        bbsChinaPost.setDateTime(dateTime);
                        break;
                    case   "read_num":
                        bbsChinaPost.setReadNum(Integer.parseInt(value));
                        break;
                    case   "participant_num":
                        bbsChinaPost.setParticipantNum(Integer.parseInt(value));
                        break;
                    case   "reply_num":
                        bbsChinaPost.setReplyNum(Integer.parseInt(value));
                        break;
                    case  "url":
                        bbsChinaPost.setUrl(value);
                        break;
                    case  "parse_time":
                        Double time = Double.parseDouble(value) * 1000;
                        Long longTime = new Long(time.longValue());
                        bbsChinaPost.setParseTime(new Timestamp(longTime));
                        break;
                }
                Long time = new Long(rowKV.getTimestamp());
                bbsChinaPost.setTimeStamp(new Timestamp(time));
            }
            bbsChinaPostService.saveBBSChinaPost(bbsChinaPost);
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
     *评论id和文章id的处理
     */
        private List<String> getCommentId(String comment_ids){
            String[] commentIdsSplit = comment_ids.split("'");
            List<String> arrayList = new ArrayList<String>();
            for(int i = 1;i<commentIdsSplit.length;i+=2){
                 arrayList.add(commentIdsSplit[i]);
            }
            return arrayList;
        }

}