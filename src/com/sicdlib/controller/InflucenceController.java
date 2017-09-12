package com.sicdlib.controller;



import com.alibaba.fastjson.JSON;
import com.sicdlib.dto.*;

import com.sicdlib.dto.entity.*;
import com.sicdlib.service.*;
import com.sicdlib.service.pythonService.*;
import com.sicdlib.util.ForeUtil.HotValueUtil;
import com.sicdlib.util.ForeUtil.SentimentInflucenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**舆情影响力
 * Created by init on 2017/6/14.
 */
@Controller
public class InflucenceController {

    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("eventArticleService")
    private IEventArticleService eventArticleService;

    @Autowired
    @Qualifier("tableService")
    private ITableService tableService;

    @Autowired
    @Qualifier("sourceArticleNumService")
    private ISourceArticleNumService sourceArticleNumService;

    /**
     *各个网站
     */
    @Autowired
    @Qualifier("doubanGroupPostService")
    private IDoubanGroupPostService doubanGroupPostService;


    @Autowired
    @Qualifier("kdnetPostService")
    private IKDNETPostService kdnetPostService;
    @Autowired
    @Qualifier("bbsSohuPostService")
    private IBBSSohuPostService bbsSohuPostService;

    @Autowired
    @Qualifier("bbsTianyaPostService")
    private IBBSTianyaPostService bbsTianyaPostService;


    @Autowired
    @Qualifier("bbsXiciPostService")
    private IBBSXiciPostService bbsXiciPostService;

    @Autowired
    @Qualifier("xinhuaNewsService")
    private IXINHUANewsService xinhuaNewsService;

    @Autowired
    @Qualifier("xinwen110NewsService")
    private IXINWEN110NewsService xinwen110NewsService;

    @Autowired
    @Qualifier("bbsChinaPostService")
    private IBBSChinaPostService bbsChinaPostService;

    @Autowired
    @Qualifier("bbsMopPostService")
    private  IBBSMopPostService bbsMopPostService;

    @Autowired
    @Qualifier("bbsPeoplePostService")
    private IBBSPeoplePostService bbsPeoplePostService;


    @Autowired
    @Qualifier("blog163PostService")
    private IBLOG163PostService blog163PostService;


    @Autowired
    @Qualifier("blogSinaPostService")
    private IBLOGSinaPostService blogSinaPostService;

    @Autowired
    @Qualifier("blogChinaBlogService")
    private IBLOGChinaBlogService blogChinaBlogService;

    @Autowired
    @Qualifier("searchService")
    private  ISearchService searchService;

    /**
     * 搜索
     * @return
     */
    //sentiment.jsp的搜索功能
    @RequestMapping(value="keywords")
    public String search(HttpServletRequest request,Model model,String dateTime){
        String keywords = request.getParameter("search-keyword");
        List<TbSentimentInflucenceEntity>   searh_keyword= searchService.getSentimentByDateTime(keywords);
        model.addAttribute("keywords", searh_keyword);
        return "sentiment";
    }

    @RequestMapping(value="sentiment")
    public String listDailyCommentNum(HttpServletRequest req, Model model) {
        System.out.println("加载到舆情影响力..........");
        List<SourceArticleCommNum> sourceArticleCommNums = new ArrayList<>();
        String eventID = req.getParameter("eventID");
        List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        TbEventArticleEntity starttimeEventArticle = null;
        TbEventArticleEntity EndtimeEventArticle = null;
        if (eventService.getSourceEventArticle(eventID) != null){
            //1. 获得事件的开始文章
            starttimeEventArticle = eventService.getSourceEventArticle(eventID);
        }
        //2. 获得事件的结束文章
            EndtimeEventArticle = eventService.getEndtimeSourceEventArticle(eventID);
        //3. 时间平均划分10份，求每份中的舆情影响力
        String startTimeStr = starttimeEventArticle.getTime();
        String endTimeStr = EndtimeEventArticle.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sf.parse(startTimeStr);
            endDate = sf.parse(endTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到的时间是毫秒，将毫秒转换成天数
        int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
        /**
         * 策略：时间T
         * 1) T>10天,     按天计算，选取10个时间节点
         * 2) 10天>T>1天, 按每天计算
         * 3) T<1天,      按每2小时计算
         *
         */
        List<SourceArticleCommNum> sourceArticleCommNumList = new ArrayList<>();
        // 1) T>10天
        if (days > 10) {
            int internalDay = days / 10;
            //获得不同时间点的热度
            for (int i = 1; i < 11; i++) {
                Calendar ca = Calendar.getInstance();
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay * (i - 1));
                String starttime = sf.format(ca.getTime());
                ca.setTime(startDate);
                ca.add(Calendar.DATE, internalDay * i);
                String endtime = sf.format(ca.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                SourceArticleCommNum sourceArticleCommNum_douban = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsPeople = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_kdnet = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbssohu = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbstianya = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsxici = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsmop = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbschina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_bbsnews = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blog163 = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blogsina = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blogchina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_people_news = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_news_sanqin = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_news_sina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_xinhua = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_xinwen110 = new SourceArticleCommNum();
                List<DoubanGroupPostEntity> doubanGroupPostList_parttime = new ArrayList<>();
                int douban_commentNum_temp = 0;
                int bbsPeople_commentNum_temp = 0;
                int kdnet_commentNum_temp = 0;
                int bbssohu_commentNum_temp = 0;
                int bbstianya_commentNum_temp = 0;
                int bbsxici_commentNum_temp = 0;
                int bbsmop_commentNum_temp = 0;
                int bbschina_commentNum_temp = 0;
                //int bbsnews_commentNum_temp = 0;
                int blog163_commentNum_temp = 0;
                int blogsina_commentNum_temp = 0;
                int blogchina_commentNum_temp = 0;
                //int people_news_commentNum_temp = 0;
                //int news_sanqin_commentNum_temp = 0;
                //int news_sina_commentNum_temp = 0;
                //int xinhua_commentNum_temp = 0;
                int xinwen110_commentNum_temp = 0;

                for (int j = 0; j < eventArticle_parttime.size(); j++) {
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                       DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                        douban_commentNum_temp += douban.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_people_post")) {
                        BbsPeoplePostEntity  bbsPeople = bbsPeoplePostService.getBbsPeoplePost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsPeople_commentNum_temp +=  bbsPeople.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("kdnet_post")){
                        KdnetPostEntity kdnet = kdnetPostService.getKdnetPost(eventArticle_parttime.get(j).getSourceArticleId());
                        if(kdnet !=null){
                            kdnet_commentNum_temp += kdnet.getCommentNum();
                            System.out.println("凯迪bbs评论数：" + kdnet.getCommentNum());
                        }
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_sohu_post")){
                        BbsSohuPostEntity bbsSohu = bbsSohuPostService.getBbsSohuPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbssohu_commentNum_temp  += bbsSohu.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_tianya_post")){
                        BbsTianyaPostEntity bbsTianya = bbsTianyaPostService.getBbsTianyaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbstianya_commentNum_temp +=bbsTianya.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_xici_post")){
                        BbsXiciPostEntity bbsXici = bbsXiciPostService.getBbsXiciPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsxici_commentNum_temp +=bbsXici.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_china_post")){
                        BbsChinaPostEntity bbsChina =bbsChinaPostService.getBbsChinaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbschina_commentNum_temp +=bbsChina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_mop_post")){
                        BbsMopPostEntity bbsMop = bbsMopPostService.getBbsMopPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsmop_commentNum_temp +=bbsMop.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blog_163_post")){
                        Blog163PostEntity blog163 = blog163PostService.getBlog163Post(eventArticle_parttime.get(j).getSourceArticleId());
                        blog163_commentNum_temp += blog163.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blog_sina_post")){
                        BlogSinaPostEntity blogSina = blogSinaPostService.getBlogSinaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        blogsina_commentNum_temp += blogSina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blogchina_blog")){
                      BlogchinaBlogEntity blogchina = blogChinaBlogService.getBlogchinaBlog(eventArticle_parttime.get(j).getSourceArticleId());
                      blogchina_commentNum_temp +=blogchina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("xinwen110_news")){
                        Xinwen110NewsEntity xinwen = xinwen110NewsService.getXinwen110News(eventArticle_parttime.get(j).getSourceArticleId());
                        xinwen110_commentNum_temp +=xinwen.getCommentNum();
                    }
                }
                //豆瓣
                sourceArticleCommNum_douban.setNum(douban_commentNum_temp);
                sourceArticleCommNum_douban.setStartTime(starttime);
                sourceArticleCommNum_douban.setEndTime(endtime);
                sourceArticleCommNum_douban.setTableName("douban_group_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_douban);
                //人民网
                sourceArticleCommNum_bbsPeople.setNum(bbsPeople_commentNum_temp);
                sourceArticleCommNum_bbsPeople.setStartTime(starttime);
                sourceArticleCommNum_bbsPeople.setEndTime(endtime);
                sourceArticleCommNum_bbsPeople.setTableName("bbs_people_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsPeople);
                //凯迪社区
                sourceArticleCommNum_kdnet.setNum(kdnet_commentNum_temp);
                sourceArticleCommNum_kdnet.setStartTime(starttime);
                sourceArticleCommNum_kdnet.setEndTime(endtime);
                sourceArticleCommNum_kdnet.setTableName("kdnet_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_kdnet);
                //搜狐社区
                sourceArticleCommNum_bbssohu.setNum(bbssohu_commentNum_temp);
                sourceArticleCommNum_bbssohu.setStartTime(starttime);
                sourceArticleCommNum_bbssohu.setEndTime(endtime);
                sourceArticleCommNum_bbssohu.setTableName("bbs_sohu_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbssohu);
                //天涯社区
                sourceArticleCommNum_bbstianya.setNum(bbstianya_commentNum_temp);
                sourceArticleCommNum_bbstianya.setStartTime(starttime);
                sourceArticleCommNum_bbstianya.setEndTime(endtime);
                sourceArticleCommNum_bbstianya.setTableName("bbs_tianya_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbstianya);
                //西祠社区
                sourceArticleCommNum_bbsxici.setNum(bbsxici_commentNum_temp);
                sourceArticleCommNum_bbsxici.setStartTime(starttime);
                sourceArticleCommNum_bbsxici.setEndTime(endtime);
                sourceArticleCommNum_bbsxici.setTableName("bbs_xici_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsxici);
                //中华网论坛
                sourceArticleCommNum_bbschina.setNum(bbschina_commentNum_temp);
                sourceArticleCommNum_bbschina.setStartTime(starttime);
                sourceArticleCommNum_bbschina.setEndTime(endtime);
                sourceArticleCommNum_bbschina.setTableName("bbs_china_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbschina);
                //猫扑社区
                sourceArticleCommNum_bbsmop.setNum(bbsmop_commentNum_temp);
                sourceArticleCommNum_bbsmop.setStartTime(starttime);
                sourceArticleCommNum_bbsmop.setEndTime(endtime);
                sourceArticleCommNum_bbsmop.setTableName("bbs_mop_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsmop);
                //网易博客
                sourceArticleCommNum_blog163.setNum(blog163_commentNum_temp);
                sourceArticleCommNum_blog163.setStartTime(starttime);
                sourceArticleCommNum_blog163.setEndTime(endtime);
                sourceArticleCommNum_blog163.setTableName("blog_163_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_blog163);
                //新浪博客
                sourceArticleCommNum_blogsina.setNum(blogsina_commentNum_temp);
                sourceArticleCommNum_blogsina.setStartTime(starttime);
                sourceArticleCommNum_blogsina.setEndTime(endtime);
                sourceArticleCommNum_blogsina.setTableName("blog_sina_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_blogsina);
                //博客中国
                sourceArticleCommNum_blogchina.setNum(blogchina_commentNum_temp);
                sourceArticleCommNum_blogchina.setStartTime(starttime);
                sourceArticleCommNum_blogchina.setEndTime(endtime);
                sourceArticleCommNum_blogchina.setTableName("blogchina_blog");
                sourceArticleCommNumList.add(sourceArticleCommNum_blogchina);
                //中国社会新闻网
                sourceArticleCommNum_xinwen110.setNum(xinwen110_commentNum_temp);
                sourceArticleCommNum_xinwen110.setStartTime(starttime);
                sourceArticleCommNum_xinwen110.setEndTime(endtime);
                sourceArticleCommNum_xinwen110.setTableName("xinwen110_news");
                sourceArticleCommNumList.add(sourceArticleCommNum_xinwen110);
            }

        }
        // 2)10天>T>1天
        else if (days < 10 && days > 1) {
            for (int i = 1; i < days + 1; i++) {
                Calendar ca = Calendar.getInstance();
                ca.setTime(startDate);
                ca.add(Calendar.DATE, (i - 1));
                String starttime = sf.format(ca.getTime());
                ca.setTime(startDate);
                ca.add(Calendar.DATE, i);
                String endtime = sf.format(ca.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                SourceArticleCommNum sourceArticleCommNum_douban = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsPeople = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_kdnet = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbssohu = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbstianya = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsxici = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsmop = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbschina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_bbsnews = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blog163 = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blogsina = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blogchina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_people_news = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_news_sanqin = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_news_sina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_xinhua = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_xinwen110 = new SourceArticleCommNum();
                List<DoubanGroupPostEntity> doubanGroupPostList_parttime = new ArrayList<>();
                int douban_commentNum_temp = 0;
                int bbsPeople_commentNum_temp = 0;
                int kdnet_commentNum_temp = 0;
                int bbssohu_commentNum_temp = 0;
                int bbstianya_commentNum_temp = 0;
                int bbsxici_commentNum_temp = 0;
                int bbsmop_commentNum_temp = 0;
                int bbschina_commentNum_temp = 0;
                //int bbsnews_commentNum_temp = 0;
                int blog163_commentNum_temp = 0;
                int blogsina_commentNum_temp = 0;
                int blogchina_commentNum_temp = 0;
                //int people_news_commentNum_temp = 0;
                //int news_sanqin_commentNum_temp = 0;
                //int news_sina_commentNum_temp = 0;
                //int xinhua_commentNum_temp = 0;
                int xinwen110_commentNum_temp = 0;

                for (int j = 0; j < eventArticle_parttime.size(); j++) {
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                        DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                        douban_commentNum_temp += douban.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_people_post")) {
                        BbsPeoplePostEntity  bbsPeople = bbsPeoplePostService.getBbsPeoplePost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsPeople_commentNum_temp +=  bbsPeople.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("kdnet_post")){
                        KdnetPostEntity kdnet = kdnetPostService.getKdnetPost(eventArticle_parttime.get(j).getSourceArticleId());
                        if(kdnet !=null){
                            kdnet_commentNum_temp += kdnet.getCommentNum();
                            System.out.println("凯迪bbs评论数：" + kdnet.getCommentNum());
                        }
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_sohu_post")){
                        BbsSohuPostEntity bbsSohu = bbsSohuPostService.getBbsSohuPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbssohu_commentNum_temp  += bbsSohu.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_tianya_post")){
                        BbsTianyaPostEntity bbsTianya = bbsTianyaPostService.getBbsTianyaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbstianya_commentNum_temp +=bbsTianya.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_xici_post")){
                        BbsXiciPostEntity bbsXici = bbsXiciPostService.getBbsXiciPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsxici_commentNum_temp +=bbsXici.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_china_post")){
                        BbsChinaPostEntity bbsChina =bbsChinaPostService.getBbsChinaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbschina_commentNum_temp +=bbsChina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_mop_post")){
                        BbsMopPostEntity bbsMop = bbsMopPostService.getBbsMopPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsmop_commentNum_temp +=bbsMop.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blog_163_post")){
                        Blog163PostEntity blog163 = blog163PostService.getBlog163Post(eventArticle_parttime.get(j).getSourceArticleId());
                        blog163_commentNum_temp += blog163.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blog_sina_post")){
                        BlogSinaPostEntity blogSina = blogSinaPostService.getBlogSinaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        blogsina_commentNum_temp += blogSina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blogchina_blog")){
                        BlogchinaBlogEntity blogchina = blogChinaBlogService.getBlogchinaBlog(eventArticle_parttime.get(j).getSourceArticleId());
                        blogchina_commentNum_temp +=blogchina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("xinwen110_news")){
                        Xinwen110NewsEntity xinwen = xinwen110NewsService.getXinwen110News(eventArticle_parttime.get(j).getSourceArticleId());
                        xinwen110_commentNum_temp +=xinwen.getCommentNum();
                    }
                }
                //豆瓣
                sourceArticleCommNum_douban.setNum(douban_commentNum_temp);
                sourceArticleCommNum_douban.setStartTime(starttime);
                sourceArticleCommNum_douban.setEndTime(endtime);
                sourceArticleCommNum_douban.setTableName("douban_group_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_douban);
                //人民网
                sourceArticleCommNum_bbsPeople.setNum(bbsPeople_commentNum_temp);
                sourceArticleCommNum_bbsPeople.setStartTime(starttime);
                sourceArticleCommNum_bbsPeople.setEndTime(endtime);
                sourceArticleCommNum_bbsPeople.setTableName("bbs_people_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsPeople);
                //凯迪社区
                sourceArticleCommNum_kdnet.setNum(kdnet_commentNum_temp);
                sourceArticleCommNum_kdnet.setStartTime(starttime);
                sourceArticleCommNum_kdnet.setEndTime(endtime);
                sourceArticleCommNum_kdnet.setTableName("kdnet_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_kdnet);
                //搜狐社区
                sourceArticleCommNum_bbssohu.setNum(bbssohu_commentNum_temp);
                sourceArticleCommNum_bbssohu.setStartTime(starttime);
                sourceArticleCommNum_bbssohu.setEndTime(endtime);
                sourceArticleCommNum_bbssohu.setTableName("bbs_sohu_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbssohu);
                //天涯社区
                sourceArticleCommNum_bbstianya.setNum(bbstianya_commentNum_temp);
                sourceArticleCommNum_bbstianya.setStartTime(starttime);
                sourceArticleCommNum_bbstianya.setEndTime(endtime);
                sourceArticleCommNum_bbstianya.setTableName("bbs_tianya_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbstianya);
                //西祠社区
                sourceArticleCommNum_bbsxici.setNum(bbsxici_commentNum_temp);
                sourceArticleCommNum_bbsxici.setStartTime(starttime);
                sourceArticleCommNum_bbsxici.setEndTime(endtime);
                sourceArticleCommNum_bbsxici.setTableName("bbs_xici_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsxici);
                //中华网论坛
                sourceArticleCommNum_bbschina.setNum(bbschina_commentNum_temp);
                sourceArticleCommNum_bbschina.setStartTime(starttime);
                sourceArticleCommNum_bbschina.setEndTime(endtime);
                sourceArticleCommNum_bbschina.setTableName("bbs_china_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbschina);
                //猫扑社区
                sourceArticleCommNum_bbsmop.setNum(bbsmop_commentNum_temp);
                sourceArticleCommNum_bbsmop.setStartTime(starttime);
                sourceArticleCommNum_bbsmop.setEndTime(endtime);
                sourceArticleCommNum_bbsmop.setTableName("bbs_mop_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsmop);
                //网易博客
                sourceArticleCommNum_blog163.setNum(blog163_commentNum_temp);
                sourceArticleCommNum_blog163.setStartTime(starttime);
                sourceArticleCommNum_blog163.setEndTime(endtime);
                sourceArticleCommNum_blog163.setTableName("blog_163_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_blog163);
                //新浪博客
                sourceArticleCommNum_blogsina.setNum(blogsina_commentNum_temp);
                sourceArticleCommNum_blogsina.setStartTime(starttime);
                sourceArticleCommNum_blogsina.setEndTime(endtime);
                sourceArticleCommNum_blogsina.setTableName("blog_sina_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_blogsina);
                //博客中国
                sourceArticleCommNum_blogchina.setNum(blogchina_commentNum_temp);
                sourceArticleCommNum_blogchina.setStartTime(starttime);
                sourceArticleCommNum_blogchina.setEndTime(endtime);
                sourceArticleCommNum_blogchina.setTableName("blogchina_blog");
                sourceArticleCommNumList.add(sourceArticleCommNum_blogchina);
                //中国社会新闻网
                sourceArticleCommNum_xinwen110.setNum(xinwen110_commentNum_temp);
                sourceArticleCommNum_xinwen110.setStartTime(starttime);
                sourceArticleCommNum_xinwen110.setEndTime(endtime);
                sourceArticleCommNum_xinwen110.setTableName("xinwen110_news");
                sourceArticleCommNumList.add(sourceArticleCommNum_xinwen110);
            }

        }
        // 3) T<1 天
        else {
            int hours = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600));
            for (int i = 1; i < hours / 2; i++) {
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(startDate);
                //按小时（10）相加减
                cal.add(10, i - 1);
                String starttime = sf.format(cal.getTime());
                cal.setTime(startDate);
                cal.add(10, i);
                String endtime = sf.format(cal.getTime());
                //通过不同事件ID，开始时间，结束时间获得事件文章列表
                List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID, starttime, endtime);
                SourceArticleCommNum sourceArticleCommNum_douban = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsPeople = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_kdnet = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbssohu = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbstianya = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsxici = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbsmop = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_bbschina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_bbsnews = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blog163 = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blogsina = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_blogchina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_people_news = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_news_sanqin = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_news_sina = new SourceArticleCommNum();
                //SourceArticleCommNum sourceArticleCommNum_xinhua = new SourceArticleCommNum();
                SourceArticleCommNum sourceArticleCommNum_xinwen110 = new SourceArticleCommNum();
                List<DoubanGroupPostEntity> doubanGroupPostList_parttime = new ArrayList<>();
                int douban_commentNum_temp = 0;
                int bbsPeople_commentNum_temp = 0;
                int kdnet_commentNum_temp = 0;
                int bbssohu_commentNum_temp = 0;
                int bbstianya_commentNum_temp = 0;
                int bbsxici_commentNum_temp = 0;
                int bbsmop_commentNum_temp = 0;
                int bbschina_commentNum_temp = 0;
                //int bbsnews_commentNum_temp = 0;
                int blog163_commentNum_temp = 0;
                int blogsina_commentNum_temp = 0;
                int blogchina_commentNum_temp = 0;
                //int people_news_commentNum_temp = 0;
                //int news_sanqin_commentNum_temp = 0;
                //int news_sina_commentNum_temp = 0;
                //int xinhua_commentNum_temp = 0;
                int xinwen110_commentNum_temp = 0;

                for (int j = 0; j < eventArticle_parttime.size(); j++) {
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                        DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                        douban_commentNum_temp += douban.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_people_post")) {
                        BbsPeoplePostEntity  bbsPeople = bbsPeoplePostService.getBbsPeoplePost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsPeople_commentNum_temp +=  bbsPeople.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("kdnet_post")){
                        KdnetPostEntity kdnet = kdnetPostService.getKdnetPost(eventArticle_parttime.get(j).getSourceArticleId());
                        if(kdnet !=null){
                            kdnet_commentNum_temp += kdnet.getCommentNum();
                            System.out.println("凯迪bbs评论数：" + kdnet.getCommentNum());
                        }
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_sohu_post")){
                        BbsSohuPostEntity bbsSohu = bbsSohuPostService.getBbsSohuPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbssohu_commentNum_temp  += bbsSohu.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_tianya_post")){
                        BbsTianyaPostEntity bbsTianya = bbsTianyaPostService.getBbsTianyaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbstianya_commentNum_temp +=bbsTianya.getCommentNum();
                    }
                    if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_xici_post")){
                        BbsXiciPostEntity bbsXici = bbsXiciPostService.getBbsXiciPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsxici_commentNum_temp +=bbsXici.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_china_post")){
                        BbsChinaPostEntity bbsChina =bbsChinaPostService.getBbsChinaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbschina_commentNum_temp +=bbsChina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_mop_post")){
                        BbsMopPostEntity bbsMop = bbsMopPostService.getBbsMopPost(eventArticle_parttime.get(j).getSourceArticleId());
                        bbsmop_commentNum_temp +=bbsMop.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blog_163_post")){
                        Blog163PostEntity blog163 = blog163PostService.getBlog163Post(eventArticle_parttime.get(j).getSourceArticleId());
                        blog163_commentNum_temp += blog163.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blog_sina_post")){
                        BlogSinaPostEntity blogSina = blogSinaPostService.getBlogSinaPost(eventArticle_parttime.get(j).getSourceArticleId());
                        blogsina_commentNum_temp += blogSina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("blogchina_blog")){
                        BlogchinaBlogEntity blogchina = blogChinaBlogService.getBlogchinaBlog(eventArticle_parttime.get(j).getSourceArticleId());
                        blogchina_commentNum_temp +=blogchina.getCommentNum();
                    }if(eventArticle_parttime.get(j).getTable().getTableName().equals("xinwen110_news")){
                        Xinwen110NewsEntity xinwen = xinwen110NewsService.getXinwen110News(eventArticle_parttime.get(j).getSourceArticleId());
                        xinwen110_commentNum_temp +=xinwen.getCommentNum();
                    }
                }
                //豆瓣
                sourceArticleCommNum_douban.setNum(douban_commentNum_temp);
                sourceArticleCommNum_douban.setStartTime(starttime);
                sourceArticleCommNum_douban.setEndTime(endtime);
                sourceArticleCommNum_douban.setTableName("douban_group_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_douban);
                //人民网
                sourceArticleCommNum_bbsPeople.setNum(bbsPeople_commentNum_temp);
                sourceArticleCommNum_bbsPeople.setStartTime(starttime);
                sourceArticleCommNum_bbsPeople.setEndTime(endtime);
                sourceArticleCommNum_bbsPeople.setTableName("bbs_people_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsPeople);
                //凯迪社区
                sourceArticleCommNum_kdnet.setNum(kdnet_commentNum_temp);
                sourceArticleCommNum_kdnet.setStartTime(starttime);
                sourceArticleCommNum_kdnet.setEndTime(endtime);
                sourceArticleCommNum_kdnet.setTableName("kdnet_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_kdnet);
                //搜狐社区
                sourceArticleCommNum_bbssohu.setNum(bbssohu_commentNum_temp);
                sourceArticleCommNum_bbssohu.setStartTime(starttime);
                sourceArticleCommNum_bbssohu.setEndTime(endtime);
                sourceArticleCommNum_bbssohu.setTableName("bbs_sohu_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbssohu);
                //天涯社区
                sourceArticleCommNum_bbstianya.setNum(bbstianya_commentNum_temp);
                sourceArticleCommNum_bbstianya.setStartTime(starttime);
                sourceArticleCommNum_bbstianya.setEndTime(endtime);
                sourceArticleCommNum_bbstianya.setTableName("bbs_tianya_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbstianya);
                //西祠社区
                sourceArticleCommNum_bbsxici.setNum(bbsxici_commentNum_temp);
                sourceArticleCommNum_bbsxici.setStartTime(starttime);
                sourceArticleCommNum_bbsxici.setEndTime(endtime);
                sourceArticleCommNum_bbsxici.setTableName("bbs_xici_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsxici);
                //中华网论坛
                sourceArticleCommNum_bbschina.setNum(bbschina_commentNum_temp);
                sourceArticleCommNum_bbschina.setStartTime(starttime);
                sourceArticleCommNum_bbschina.setEndTime(endtime);
                sourceArticleCommNum_bbschina.setTableName("bbs_china_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbschina);
                //猫扑社区
                sourceArticleCommNum_bbsmop.setNum(bbsmop_commentNum_temp);
                sourceArticleCommNum_bbsmop.setStartTime(starttime);
                sourceArticleCommNum_bbsmop.setEndTime(endtime);
                sourceArticleCommNum_bbsmop.setTableName("bbs_mop_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_bbsmop);
                //网易博客
                sourceArticleCommNum_blog163.setNum(blog163_commentNum_temp);
                sourceArticleCommNum_blog163.setStartTime(starttime);
                sourceArticleCommNum_blog163.setEndTime(endtime);
                sourceArticleCommNum_blog163.setTableName("blog_163_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_blog163);
                //新浪博客
                sourceArticleCommNum_blogsina.setNum(blogsina_commentNum_temp);
                sourceArticleCommNum_blogsina.setStartTime(starttime);
                sourceArticleCommNum_blogsina.setEndTime(endtime);
                sourceArticleCommNum_blogsina.setTableName("blog_sina_post");
                sourceArticleCommNumList.add(sourceArticleCommNum_blogsina);
                //博客中国
                sourceArticleCommNum_blogchina.setNum(blogchina_commentNum_temp);
                sourceArticleCommNum_blogchina.setStartTime(starttime);
                sourceArticleCommNum_blogchina.setEndTime(endtime);
                sourceArticleCommNum_blogchina.setTableName("blogchina_blog");
                sourceArticleCommNumList.add(sourceArticleCommNum_blogchina);
                //中国社会新闻网
                sourceArticleCommNum_xinwen110.setNum(xinwen110_commentNum_temp);
                sourceArticleCommNum_xinwen110.setStartTime(starttime);
                sourceArticleCommNum_xinwen110.setEndTime(endtime);
                sourceArticleCommNum_xinwen110.setTableName("xinwen110_news");
                sourceArticleCommNumList.add(sourceArticleCommNum_xinwen110);
            }
        }
        System.out.println(sourceArticleCommNumList.size());
        model.addAttribute("commlist",JSON.toJSON(sourceArticleCommNumList));
        System.out.println(JSON.toJSON(sourceArticleCommNumList));
        return "sentiment";
    }





    /**
     * 网民的参与度
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "participant")
    public String  listParticipant(HttpServletRequest req,Model model){
        System.out.println("加载网民参与度...............");
        String eventID = req.getParameter("eventID");
        List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        //获得网名的参与度
        List<TbNetizenParticiEntity> tbNetizenPartici = SentimentInflucenceUtil.getNetizenParticiByArticles(eventArticles);
        List<TbNetizenParticiEntity> tbNetizenParticiTop10 = new ArrayList<>();
        List<TbNetizenParticiEntity> tbNetizenParticiTop10_douban = new ArrayList<>();
        List<TbNetizenParticiEntity> tbNetizenParticiTop10_bbspeople = new ArrayList<>();
        List<TbNetizenParticiEntity> tbNetizenParticiTop10_bbssohu = new ArrayList<>();
        int top10flag = 0;
        int top10_doubanflag = 0;
        int top10_bbspeopleflag = 0;
        int top10_bbssohuflag = 0;
        for(int i = 0;top10flag < 10 && top10_doubanflag <10 && top10_bbspeopleflag <10 && top10_bbssohuflag < 10 || i < tbNetizenPartici.size(); i++){
        //获得所有网站热度前 10 条信息
            if(top10flag < 10){
                tbNetizenParticiTop10.add(tbNetizenPartici.get(i));
                top10flag ++;
            }
            //豆瓣小组:热度前10条
            if(top10_doubanflag < 10 && tbNetizenPartici.get(i).getDoubanGroupPost() !=null){
                tbNetizenParticiTop10_douban.add(tbNetizenPartici.get(i));
                top10_doubanflag ++;
            }
            //人民网bbs：热度前10条
            if(top10_bbspeopleflag <10 && tbNetizenPartici.get(i).getBbsPeoplePost() !=null){
                tbNetizenParticiTop10_bbspeople.add(tbNetizenPartici.get(i));
                top10_bbspeopleflag ++;
            }
            //搜狐bbs:热度前10条
            if(top10_bbssohuflag <10 && tbNetizenPartici.get(i).getBbsSohuPost() !=null){
                tbNetizenParticiTop10_bbssohu.add(tbNetizenPartici.get(i));
                top10_bbssohuflag ++;
            }
        }
        System.out.println(tbNetizenParticiTop10.size() + ":" + tbNetizenParticiTop10_douban.size() + ":" + tbNetizenParticiTop10_bbspeople.size() +":" +tbNetizenParticiTop10_bbssohu.size());
        model.addAttribute("tbNetizenParticiTop10",tbNetizenParticiTop10);
        model.addAttribute("tbNetizenParticiTop10_douban",tbNetizenParticiTop10_douban);
        model.addAttribute("tbNetizenParticiTop10_bbspeople",tbNetizenParticiTop10_bbspeople);
        model.addAttribute("tbNetizenParticiTop10_bbssohu",tbNetizenParticiTop10_bbssohu);
        model.addAttribute("eventId",eventID);
        req.getSession().setAttribute("eventID",eventID);
        return "participant";
    }
    /**
     * 舆情负面指数
     *
     */
    @RequestMapping(value="negativeIndex")
    public String listNegativeIndex(HttpServletRequest request,Model model){
        System.out.println("加载到舆情负面指数..........");
        String eventID = request.getParameter("eventID");
        List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        TbEventArticleEntity  starttimeEventArticle = null;
        if(eventService.getSourceEventArticle(eventID) != null){
           // 1.获得事件的开始文章
           starttimeEventArticle =  eventService.getSourceEventArticle(eventID);
        }
            //2.获得事件的结束文章
            TbEventArticleEntity   endtimeEventArticle = eventService.getEndtimeSourceEventArticle(eventID);
            //3.时间平均划分10份，求每份中的舆情负面指数
            String startTimeStr = starttimeEventArticle.getTime();
            String endTimeStr = endtimeEventArticle.getTime();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            Date startDate = null;
            Date endDate = null;
        try {
            startDate = sf.parse(startTimeStr);
            endDate = sf.parse(endTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到的时间是毫秒，将毫秒转换成天数
            int days = (int) ((endDate.getTime()-startDate.getTime()) /(24*60*60*1000));
        /**
         *
         * 策略：时间 T
         * 1）T>10天， 按天计算，选取10个时间节点
         * 2） 10天>T>1天，按每天计算
         * 3）T<1天，按每2小时计算
         *
         */
            List<TbSourceArticleIndex>  sourceArticleIndexList = new ArrayList<>();
            // 1) T>10天
             if(days > 10){
                 int  internalDay = days / 10;
                 //获得不同时间点的舆情负面指数
                 for(int i=1; i<11;i++){
                    Calendar ca = Calendar.getInstance();
                    ca.setTime(startDate);
                    ca.add(Calendar.DATE,internalDay * (i - 1));
                    String starttime = sf.format(ca.getTime());
                    ca.setTime(startDate);
                    ca.add(Calendar.DATE,internalDay * i);
                    String endtime = sf.format(ca.getTime());
                    //通过不同事件ID，开始时间、结束时间获得事件文章列表
                     List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID,starttime,endtime);
                     TbSourceArticleIndex sourceArticleIndex_douban = new TbSourceArticleIndex();
                     TbSourceArticleIndex sourceArticleIndex_bbspeople = new TbSourceArticleIndex();
                     TbSourceArticleIndex sourceArticleIndex_bbssohu = new TbSourceArticleIndex();
                     double douban_temp = 0.0;
                     double bbspeople_temp = 0.0;
                     double bbssohu_temp = 0.0;
                     for(int j=0;j<eventArticle_parttime.size();j++) {
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                             DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             douban_temp += (0.2 * douban.getCommentNum()) / (douban.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             douban_temp = Double.parseDouble(df.format(douban_temp));
                         }
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_people_post")) {
                             BbsPeoplePostEntity bbspeople = bbsPeoplePostService.getBbsPeoplePost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             bbspeople_temp += (0.2 * bbspeople.getCommentNum()) / (bbspeople.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             bbspeople_temp = Double.parseDouble(df.format(bbspeople_temp));
                         }
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_sohu_post")) {
                             BbsSohuPostEntity bbssohu = bbsSohuPostService.getBbsSohuPost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             bbssohu_temp += (0.2 * bbssohu.getCommentNum()) / (bbssohu.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             bbssohu_temp = Double.parseDouble(df.format(bbssohu_temp));
                         }
                     }
                         //豆瓣小组
                         sourceArticleIndex_douban.setIndex(douban_temp);
                         sourceArticleIndex_douban.setStartTime(starttime);
                         sourceArticleIndex_douban.setEndTime(endtime);
                         sourceArticleIndex_douban.setTableName("douban_group_post");
                         sourceArticleIndexList.add(sourceArticleIndex_douban);
                         //人人网
                         sourceArticleIndex_bbspeople.setIndex(bbspeople_temp);
                         sourceArticleIndex_bbspeople.setStartTime(starttime);
                         sourceArticleIndex_bbspeople.setEndTime(endtime);
                         sourceArticleIndex_bbspeople.setTableName("bbs_people_post");
                         sourceArticleIndexList.add(sourceArticleIndex_bbspeople);
                         //搜狐网
                         sourceArticleIndex_bbssohu.setIndex(bbssohu_temp);
                         sourceArticleIndex_bbssohu.setStartTime(starttime);
                         sourceArticleIndex_bbssohu.setEndTime(endtime);
                         sourceArticleIndex_bbssohu.setTableName("bbs_sohu_post");
                         sourceArticleIndexList.add(sourceArticleIndex_bbssohu);
                     }
                 }
             // 10天 > day > 1天
             else if(10 > days && days >1){
                 for(int i = 1;i <days +1;i++){
                     Calendar ca = Calendar.getInstance();
                     ca.setTime(startDate);
                     ca.add(Calendar.DATE,(i - 1));
                     String starttime = sf.format(ca.getTime());
                     ca.setTime(startDate);
                     ca.add(Calendar.DATE,i);
                     String endtime = sf.format(ca.getTime());
                     //通过不同事件ID，开始时间、结束时间获得事件文章列表
                     List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID,starttime,endtime);
                     TbSourceArticleIndex sourceArticleIndex_douban = new TbSourceArticleIndex();
                     TbSourceArticleIndex sourceArticleIndex_bbspeople = new TbSourceArticleIndex();
                     TbSourceArticleIndex sourceArticleIndex_bbssohu = new TbSourceArticleIndex();
                     double douban_temp = 0.0;
                     double bbspeople_temp = 0.0;
                     double bbssohu_temp = 0.0;
                     for(int j=0;j<eventArticle_parttime.size();j++) {
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                             DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             douban_temp += (0.2 * douban.getCommentNum()) / (douban.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             douban_temp = Double.parseDouble(df.format(douban_temp));
                         }
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_people_post")) {
                             BbsPeoplePostEntity bbspeople = bbsPeoplePostService.getBbsPeoplePost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             bbspeople_temp += (0.2 * bbspeople.getCommentNum()) / (bbspeople.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             bbspeople_temp = Double.parseDouble(df.format(bbspeople_temp));
                         }
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_sohu_post")) {
                             BbsSohuPostEntity bbssohu = bbsSohuPostService.getBbsSohuPost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             bbssohu_temp += (0.2 * bbssohu.getCommentNum()) / (bbssohu.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             bbssohu_temp = Double.parseDouble(df.format(bbssohu_temp));
                         }
                     }
                     //豆瓣小组
                     sourceArticleIndex_douban.setIndex(douban_temp);
                     sourceArticleIndex_douban.setStartTime(starttime);
                     sourceArticleIndex_douban.setEndTime(endtime);
                     sourceArticleIndex_douban.setTableName("douban_group_post");
                     sourceArticleIndexList.add(sourceArticleIndex_douban);
                     //人人网
                     sourceArticleIndex_bbspeople.setIndex(bbspeople_temp);
                     sourceArticleIndex_bbspeople.setStartTime(starttime);
                     sourceArticleIndex_bbspeople.setEndTime(endtime);
                     sourceArticleIndex_bbspeople.setTableName("bbs_people_post");
                     sourceArticleIndexList.add(sourceArticleIndex_bbspeople);
                     //搜狐网
                     sourceArticleIndex_bbssohu.setIndex(bbssohu_temp);
                     sourceArticleIndex_bbssohu.setStartTime(starttime);
                     sourceArticleIndex_bbssohu.setEndTime(endtime);
                     sourceArticleIndex_bbssohu.setTableName("bbs_sohu_post");
                     sourceArticleIndexList.add(sourceArticleIndex_bbssohu);
                 }
             }
                // 3）T < 1 天
        else{
                 int hours =(int) ((endDate.getTime() - endDate.getTime()) / (60*60*1000));
                 for(int i = 1 ; i< hours / 2; i++){
                   GregorianCalendar cal = new GregorianCalendar();
                     cal.setTime(startDate);
                   //按小时(10)相加减
                     cal.add(10,i-1);
                     String starttime = sf.format(cal.getTime());
                     cal.setTime(startDate);
                     cal.add(10,i);
                     String endtime = sf.format(cal.getTime());
                     //通过不同事件ID，开始时间、结束时间获得事件文章列表
                     List<TbEventArticleEntity> eventArticle_parttime = eventArticleService.getEventArticlesByStartEndTime(eventID,starttime,endtime);
                     TbSourceArticleIndex sourceArticleIndex_douban = new TbSourceArticleIndex();
                     TbSourceArticleIndex sourceArticleIndex_bbspeople = new TbSourceArticleIndex();
                     TbSourceArticleIndex sourceArticleIndex_bbssohu = new TbSourceArticleIndex();
                     double douban_temp = 0.0;
                     double bbspeople_temp = 0.0;
                     double bbssohu_temp = 0.0;
                     for(int j=0;j<eventArticle_parttime.size();j++) {
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("douban_group_post")) {
                             DoubanGroupPostEntity douban = doubanGroupPostService.getDoubanGroupPost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             douban_temp += (0.2 * douban.getCommentNum()) / (douban.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             douban_temp = Double.parseDouble(df.format(douban_temp));
                         }
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_people_post")) {
                             BbsPeoplePostEntity bbspeople = bbsPeoplePostService.getBbsPeoplePost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             bbspeople_temp += (0.2 * bbspeople.getCommentNum()) / (bbspeople.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             bbspeople_temp = Double.parseDouble(df.format(bbspeople_temp));
                         }
                         if (eventArticle_parttime.get(j).getTable().getTableName().equals("bbs_sohu_post")) {
                             BbsSohuPostEntity bbssohu = bbsSohuPostService.getBbsSohuPost(eventArticle_parttime.get(j).getSourceArticleId());
                             //计算舆情负面指数: I = g1 * C / R;(I = 0.2 * C / R)
                             bbssohu_temp += (0.2 * bbssohu.getCommentNum()) / (bbssohu.getCommentNum() + 10);
                             DecimalFormat df = new DecimalFormat("#.00");
                             bbssohu_temp = Double.parseDouble(df.format(bbssohu_temp));
                         }
                     }
                     //豆瓣小组
                     sourceArticleIndex_douban.setIndex(douban_temp);
                     sourceArticleIndex_douban.setStartTime(starttime);
                     sourceArticleIndex_douban.setEndTime(endtime);
                     sourceArticleIndex_douban.setTableName("douban_group_post");
                     sourceArticleIndexList.add(sourceArticleIndex_douban);
                     //人人网
                     sourceArticleIndex_bbspeople.setIndex(bbspeople_temp);
                     sourceArticleIndex_bbspeople.setStartTime(starttime);
                     sourceArticleIndex_bbspeople.setEndTime(endtime);
                     sourceArticleIndex_bbspeople.setTableName("bbs_people_post");
                     sourceArticleIndexList.add(sourceArticleIndex_bbspeople);
                     //搜狐网
                     sourceArticleIndex_bbssohu.setIndex(bbssohu_temp);
                     sourceArticleIndex_bbssohu.setStartTime(starttime);
                     sourceArticleIndex_bbssohu.setEndTime(endtime);
                     sourceArticleIndex_bbssohu.setTableName("bbs_sohu_post");
                     sourceArticleIndexList.add(sourceArticleIndex_bbssohu);
                 }
             }
               System.out.println("舆情负面指数..."+sourceArticleIndexList.size());
               model.addAttribute("indexList",JSON.toJSON(sourceArticleIndexList));
               System.out.println("舆情负面指数的json格式...." +JSON.toJSON(sourceArticleIndexList));
               return "negativeIndex";
    }


    /**
     * 舆情的引爆点
     * explore
     */
    @RequestMapping(value="explore")
    public String explore(HttpServletRequest request,Model model){
        System.out.println("加载舆情的引爆点.........");
        String eventID = request.getParameter("eventID");
        List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
        //获得网民的信息，体现舆情的爆发点
        List<TableHotValue> hotValues =  HotValueUtil.getTableHotValueByArticles(eventArticles);
        List<TableHotValue> hotValuestop10 = new ArrayList<>();
        List<TableHotValue> hotValuestop10_douban = new ArrayList<>();
        List<TableHotValue> hotValuestop10_bbspeople = new ArrayList<>();
        List<TableHotValue> hotValuestop10_bbssohu = new ArrayList<>();
        int top10flag = 0;
        int top10_doubanflag = 0;
        int top10_bbspeopleflag = 0;
        int top10_bbssohuflag = 0;
        for( int i = 0;top10flag < 10 && top10_doubanflag < 10 && top10_bbspeopleflag < 10 && top10_bbssohuflag < 10 || i < hotValues.size();i++){
            //获得所有网站热度的前十条
            if(top10flag < 10){
                hotValuestop10.add(hotValues.get(i));
                top10flag ++;
            }
            //豆瓣小组:热度前10条
            if(top10_doubanflag <10 && hotValues.get(i).getDoubanGroupPost() != null){
                hotValuestop10_douban.add(hotValues.get(i));
                top10_doubanflag ++;
            }
            //人民网：热度前10天
            if(top10_bbspeopleflag < 10 && hotValues.get(i).getBbsPeoplePost() !=null){
                hotValuestop10_bbspeople.add(hotValues.get(i));
                top10_bbspeopleflag ++;
            }
            if(top10_bbssohuflag < 10 && hotValues.get(i).getBbssohuPost() !=null){
                hotValuestop10_bbssohu.add(hotValues.get(i));
                top10_bbssohuflag ++;
            }
        }
        System.out.println("引爆点....."+hotValuestop10.size()+":"+hotValuestop10_douban.size()+":"+hotValuestop10_bbspeople.size()+":"+hotValuestop10_bbssohu.size());
        model.addAttribute("hotValuestop10",hotValuestop10);
        model.addAttribute("hotValuestop10_douban",hotValuestop10_douban);
        model.addAttribute("hotValuestop10_bbspeople",hotValuestop10_bbspeople);
        model.addAttribute("hotValuestop10_bbssohu",hotValuestop10_bbssohu);
        model.addAttribute("eventID",eventID);
        request.getSession().setAttribute("eventID",eventID);
        return "explore";
    }
}
