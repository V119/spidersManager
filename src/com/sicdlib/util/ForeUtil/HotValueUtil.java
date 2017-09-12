package com.sicdlib.util.ForeUtil;

import com.sicdlib.dto.ArticleHotValueEntity;
import com.sicdlib.dto.CleanInputEntity;
import com.sicdlib.dto.TableHotValue;
import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.XinhuaNewsEntity;
import com.sicdlib.service.IArticleHotValueService;
import com.sicdlib.service.ICleanInputService;
import com.sicdlib.service.pythonService.IBBSPeoplePostService;
import com.sicdlib.service.pythonService.IDoubanGroupPostService;
import com.sicdlib.service.pythonService.IXINHUANewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by DeMH on 2017/5/17.
 */
public class HotValueUtil {

    static ApplicationContext apx = new ClassPathXmlApplicationContext("beans.xml");
    static IDoubanGroupPostService doubanGroupPostService = (IDoubanGroupPostService)apx.getBean("doubanGroupPostService");
    static IArticleHotValueService articleHotValueService = (IArticleHotValueService)apx.getBean("articleHotValueService");
    static IBBSPeoplePostService bbsPeoplePostService = (IBBSPeoplePostService) apx.getBean("bbsPeoplePostService");
    static IXINHUANewsService xinhuaNewsService = (IXINHUANewsService) apx.getBean("xinhuaNewsService");

    /**
     *  获取某个事件在某个网站上的热度值
     *  计算公式：
     *  点赞量L，评论量C，推荐量R, 浏览量B, 回复量Rep
     *  H = 0.1*L + 0.3*C + 0.2*R
     */
    public static List<TableHotValue> getTableHotValueByArticles(List<TbEventArticleEntity> eventArticles){
        List<TableHotValue> tableHotValues = new ArrayList<TableHotValue>();
        for (int i = 0;i < eventArticles.size(); i++){
            TableHotValue tableHotValue = new TableHotValue();
            TbEventArticleEntity eventArticle = eventArticles.get(i);
            //获得单个文章的热度值
            tableHotValue = hotValueByArticle(eventArticle);
            if (tableHotValue != null){
                tableHotValues.add(tableHotValue);
            }
        }

       /*//对表(网站文章)的热度值进行排序
        Collections.sort(tableHotValues, new Comparator<TableHotValue>(){
            @Override
            public int compare(TableHotValue o1, TableHotValue o2) {
                return o2.getHotValue().compareTo(o1.getHotValue());
            }
        });*/
        return tableHotValues;
    }

    /**
     * 给定事件文章，获得单个文章的热度值
     * @param eventArticle
     * @return
     */
    public static TableHotValue hotValueByArticle(TbEventArticleEntity eventArticle){
        TableHotValue tableHotValue = new TableHotValue();
        if (eventArticle != null){
            String tableName = eventArticle.getTable().getTableName();
            //得到属于哪张表，如果属于豆瓣发布表
            if (tableName.equals("douban_group_post")){
                ArticleHotValueEntity articleHotValue = new ArticleHotValueEntity();
                DoubanGroupPostEntity doubanGroupPost = doubanGroupPostService.getDoubanGroupPost(eventArticle.getSourceArticleId());
                System.out.println(doubanGroupPost);
                if (doubanGroupPost != null){
                    //计算热度:H = 0.1*L + 0.3*C + 0.2*R
                    double hotValue = doubanGroupPost.getLikeNum() * 0.1 + doubanGroupPost.getCommentNum() * 0.3 + doubanGroupPost.getRecommendNum() * 0.2;
                    DecimalFormat df = new DecimalFormat("#.00");
                    hotValue = Double.parseDouble(df.format(hotValue));
                    tableHotValue.setHotValue(hotValue);
                    tableHotValue.setDoubanGroupPost(doubanGroupPost);
                    tableHotValue.setTableName("douban_group_post");
                    tableHotValue.setWebsiteName("豆瓣小组");
                }
            }

            if (tableName.equals("bbs_people_post")){
                BbsPeoplePostEntity bbsPeoplePost = bbsPeoplePostService.getBbsPeoplePost(eventArticle.getSourceArticleId());
                System.out.println(bbsPeoplePost);
                if (bbsPeoplePost != null){
                    //计算热度:H = 0.1*L + 0.3*C + 0.2*R
                    double hotValue = bbsPeoplePost.getReadNum() * 0.1 + bbsPeoplePost.getCommentNum() * 0.3 + bbsPeoplePost.getReplyNum() * 0.2 + bbsPeoplePost.getPriseNum() * 0.5;
                    DecimalFormat df = new DecimalFormat("#.00");
                    hotValue = Double.parseDouble(df.format(hotValue));
                    tableHotValue.setHotValue(hotValue);
                    tableHotValue.setBbsPeoplePost(bbsPeoplePost);
                    tableHotValue.setTableName("bbs_people_post");
                    tableHotValue.setWebsiteName("人民网BBS");
                }
            }

//            if (tableName.equals("xinhua_news")){
//                ArticleHotValueEntity articleHotValue = new ArticleHotValueEntity();
//                XinhuaNewsEntity xinhuaNews = xinhuaNewsService.getAllXinHuaNewsByArticleID(eventArticle.getSourceArticleId());
//                System.out.println(xinhuaNews);
//                if (xinhuaNews != null){
//                    //计算热度:H = 0.1*L + 0.3*C + 0.2*R
////                    double hotValue = xinhuaNews.getReadNum() * 0.1 + bbsPeoplePost.getCommentNum() * 0.3 + bbsPeoplePost.getReplyNum() * 0.2 + bbsPeoplePost.getPriseNum() * 0.5;
//                    double hotValue = 0.0;
//                    DecimalFormat df = new DecimalFormat("#.00");
//                    hotValue = Double.parseDouble(df.format(hotValue));
//                    tableHotValue.setHotValue(hotValue);
//                    tableHotValue.setXinhuaNews(xinhuaNews);
//                    tableHotValue.setTableName("xinhua_news");
//                    tableHotValue.setWebsiteName("新华网");
//                }
//            }
        }
        return tableHotValue;
    }

    /**
     * 插入数据库热度值: 豆瓣小组 douban_group_post
     * @param doubanGroupPosts
     */
    public static void insertHotValueBySourceArticles_doubanPosts(List<DoubanGroupPostEntity> doubanGroupPosts){
        for (int i = 0;i < doubanGroupPosts.size(); i++){
            ArticleHotValueEntity articleHotValue = new ArticleHotValueEntity();
            DoubanGroupPostEntity doubanGroupPost = doubanGroupPosts.get(i);
            //计算热度:H = 0.1*L + 0.3*C + 0.2*R
            double hotValue = doubanGroupPost.getLikeNum() * 0.1 + doubanGroupPost.getCommentNum() * 0.3 + doubanGroupPost.getRecommendNum() * 0.2;
            DecimalFormat df = new DecimalFormat("#.00");
            hotValue = Double.parseDouble(df.format(hotValue));
            //存入数据库
            articleHotValue.setHotValue(hotValue);
            articleHotValue.setTableName("douban_group_post");
            articleHotValue.setWebsiteName("豆瓣小组");
            articleHotValue.setSourceArticleId(doubanGroupPost.getId());
            articleHotValueService.addArticleHotValueByEventID(articleHotValue);
        }
    }

    /**
     * 插入数据库热度值: 人民网BBS bbs_people_post
     * @param bbsPeoplePosts
     */
    public static void insertHotValueBySourceArticles_bbsPeoplePosts(List<BbsPeoplePostEntity> bbsPeoplePosts){
        for (int i = 0;i < bbsPeoplePosts.size(); i++){
            ArticleHotValueEntity articleHotValue = new ArticleHotValueEntity();
            BbsPeoplePostEntity bbsPeoplePost = bbsPeoplePosts.get(i);
            //计算热度:H = 0.1*L + 0.3*C + 0.2*R
            double hotValue = bbsPeoplePost.getReadNum() * 0.1 + bbsPeoplePost.getCommentNum() * 0.3 + bbsPeoplePost.getReplyNum() * 0.2 + bbsPeoplePost.getPriseNum() * 0.5;
            DecimalFormat df = new DecimalFormat("#.00");
            hotValue = Double.parseDouble(df.format(hotValue));
            //存入数据库
            articleHotValue.setHotValue(hotValue);
            articleHotValue.setTableName("bbs_people_post");
            articleHotValue.setWebsiteName("人民网BBS");
            articleHotValue.setSourceArticleId(bbsPeoplePost.getId());
            articleHotValueService.addArticleHotValueByEventID(articleHotValue);
        }
    }

    /**
     * 插入数据库热度值: 新华网 xinhua_news
     * @param xinhuaNewsList
     */
    public static void insertHotValueBySourceArticles_xinhuanews(List<XinhuaNewsEntity> xinhuaNewsList){
        for (int i = 0;i < xinhuaNewsList.size(); i++){
            ArticleHotValueEntity articleHotValue = new ArticleHotValueEntity();
            XinhuaNewsEntity xinhuaNews = xinhuaNewsList.get(i);
            //计算热度:H = 0.1*L + 0.3*C + 0.2*R
//            double hotValue = xinhuaNews.getReadNum() * 0.1 + xinhuaNews.getCommentNum() * 0.3 + xinhuaNews.getReplyNum() * 0.2 + xinhuaNews.getPriseNum() * 0.5;
            double hotValue = 0.0;
            DecimalFormat df = new DecimalFormat("#.00");
            hotValue = Double.parseDouble(df.format(hotValue));
            //存入数据库
            articleHotValue.setHotValue(hotValue);
            articleHotValue.setTableName("xinhua_news");
            articleHotValue.setWebsiteName("新华网");
            articleHotValue.setSourceArticleId(xinhuaNews.getId());
            articleHotValueService.addArticleHotValueByEventID(articleHotValue);
        }
    }

}
