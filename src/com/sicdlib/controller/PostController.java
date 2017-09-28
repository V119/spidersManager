package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.dto.phoenixEntity.BBSChinaAuthorEntity;
import com.sicdlib.dto.phoenixEntity.BBSChinaCommentEntity;
import com.sicdlib.dto.phoenixEntity.BBSChinaPostEntity;
import com.sicdlib.service.hbaseService.imple.AuthorService;
import com.sicdlib.service.hbaseService.imple.CommentService;
import com.sicdlib.service.hbaseService.imple.PostService;
import com.sicdlib.util.TableUtil.ArticleAuthorTableMapping;
import com.sicdlib.util.TableUtil.ArticleCommentTableMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class PostController {

    @Autowired
    @Qualifier("postService")
    private PostService postService;

    @Autowired
    @Qualifier("authorService")
    private AuthorService authorService;

    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;


    @RequestMapping("post")
    public String post(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = req.getParameter("type");
        String condition = req.getParameter("condition");
        String conditionValue = req.getParameter("conditionValue");
        String authorType = ArticleAuthorTableMapping.getAuthorTable(type);
        if ("blogchina_blog_1".equals(type)){
            authorType = "blogchina_author_1";
        }
        if (!"xinhua_news".equals(type)){
            if(!"moe_news".equals(type))
                model.addAttribute("authorInfo", JSON.toJSON(authorService.getAuthorInfo(condition,conditionValue,authorType)));
        }
        model.addAttribute("postType",type);

        model.addAttribute(type, JSON.toJSON(postService.getPostList(type,condition,conditionValue)));
        return "posttitle_display";
    }
    @RequestMapping("postInfo")
    public String postInfo(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = req.getParameter("type");
        String commentType = ArticleCommentTableMapping.getCommentTable(type);
        String condition = req.getParameter("condition");
        String conditionValue = req.getParameter("conditionValue");
        if ("blogchina_blog_1".equals(type)){
            commentType = "blogchina_comment_1";
        }
        if (!"moe_news".equals(type)){
            if (!"blog_sina_post".equals(type)){
                if (!"bbs_people_post".equals(type)){
                    List commentList = commentService.getCommentList(commentType,condition,conditionValue);
                    model.addAttribute(commentType, JSON.toJSON(commentList));
                }

            }
        }
        model.addAttribute(type, JSON.toJSON(postService.getPostInfo(condition,type,conditionValue)));
        return "post_comment_display";
    }

    @RequestMapping("moe_news_title")
    public String moe_news_title(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type ="moe_news_title";
        String newsEditor = req.getParameter("newsEditor");

        model.addAttribute("newsEditor",newsEditor);
        model.addAttribute("postMoeList", JSON.toJSON(postService.getMoePostList("moe_news",newsEditor)));
        return "posttitle_display";
    }

    @RequestMapping("postMoeInfo")
    public String postMoeInfo(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = "moe_news";
        String newsTitle = req.getParameter("newsTitle");

        model.addAttribute("newsTitle",newsTitle);
        model.addAttribute("postMoeInfo", JSON.toJSON(postService.getMoePostInfo(newsTitle,type)));
        return "post_comment_display";
    }
    /**
     * blog_sina_posttitle,bbs_kd_posttitle,bbs_xinhua_posttitle,blog_163_posttitle,blog_china_posttitle
     * bbs_mop_posttitle,bbs_people_posttitle,bbs_sohu_posttitle,bbs_tianya_posttitle,bbs_xici_posttitle
     */

}
