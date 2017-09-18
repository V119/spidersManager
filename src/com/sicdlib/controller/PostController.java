package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.dto.entity.*;
import com.sicdlib.service.imple.AuthorService;
import com.sicdlib.service.imple.PostService;
import com.sicdlib.service.pythonService.imple.*;
import com.sicdlib.util.PageUtil.Page;
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

    public String type_to_tableName(String type){
        String tableName =null;
        if ("bbs_china_posttitle".equals(type)){
            tableName = "BbsChinaPostEntity";
        }
        if ("bbs_mop_posttitle".equals(type)){
            tableName = "BbsMopPostEntity";
        }
        if ("bbs_people_posttitle".equals(type)){
            tableName = "BbsPeoplePostEntity";
        }
        if ("bbs_sohu_posttitle".equals(type)){
            tableName = "BbsSohuPostEntity";
        }
        if ("bbs_tianya_posttitle".equals(type)){
            tableName = "BbsTianyaPostEntity";
        }
        if ("bbs_xici_posttitle".equals(type)){
            tableName = "BbsXiciPostEntity";
        }
        if ("bbs_kd_posttitle".equals(type)){
            tableName = "KdnetPostEntity";
        }
        if ("bbs_xinhua_posttitle".equals(type)){
            tableName = "XinhuaNewsEntity";
        }
        if ("blog_163_posttitle".equals(type)){
            tableName = "Blog163PostEntity";
        }
        if ("blog_china_posttitle".equals(type)){
            tableName = "BlogchinaBlogEntity";
        }
        if ("blog_sina_posttitle".equals(type)){
            tableName = "BlogSinaPostEntity";
        }

        return tableName;
    }

    public Page page(HttpServletRequest req,String type){

        int totalRecord = postService.getAllPostNum(type_to_tableName(type));//总记录数
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));//当前页码
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));;//每页显示多少条

        return new Page(totalRecord, pageIndex, pageSize);
    }

    public List postList(HttpServletRequest req,String type){
        return postService.getPostList(type_to_tableName(type),page(req,type));
    }

    @RequestMapping("bbs_china_posttitle")
    public String bbs_china_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = "bbs_china_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_china_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_china_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_china_authorInfo", JSON.toJSON((BbsChinaAuthorEntity)bbs_china_authorInfo));
        model.addAttribute("bbs_china_postInfo", JSON.toJSON((BbsChinaPostEntity)bbs_china_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }
    @RequestMapping("bbs_mop_posttitle")
    public String bbs_mop_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = "bbs_mop_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_mop_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_mop_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_mop_authorInfo", JSON.toJSON((BbsMopAuthorEntity)bbs_mop_authorInfo));
        model.addAttribute("bbs_mop_postInfo", JSON.toJSON((BbsMopPostEntity)bbs_mop_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";

    }

    @RequestMapping("bbs_people_posttitle")
    public String bbs_people_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_people_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_people_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_people_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_people_authorInfo", JSON.toJSON((BbsPeopleAuthorEntity)bbs_people_authorInfo));
        model.addAttribute("bbs_people_postInfo", JSON.toJSON((BbsPeoplePostEntity)bbs_people_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("bbs_sohu_posttitle")
    public String bbs_sohu_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_sohu_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_sohu_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_csohu_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_sohu_authorInfo", JSON.toJSON((BbsSohuAuthorEntity)bbs_sohu_authorInfo));
        model.addAttribute("bbs_sohu_postInfo", JSON.toJSON((BbsSohuPostEntity)bbs_csohu_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("bbs_tianya_posttitle")
    public String bbs_tianya_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_tianya_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_tianya_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_tianya_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_tianya_authorInfo", JSON.toJSON((BbsTianyaAuthorEntity)bbs_tianya_authorInfo));
        model.addAttribute("bbs_tianya_postInfo", JSON.toJSON((BbsTianyaPostEntity)bbs_tianya_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("bbs_xici_posttitle")
    public String bbs_xici_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_xici_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_xici_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_xici_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_xici_authorInfo", JSON.toJSON((BbsXiciAuthorEntity)bbs_xici_authorInfo));
        model.addAttribute("bbs_xici_postInfo", JSON.toJSON((BbsXiciPostEntity)bbs_xici_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("bbs_kd_posttitle")
    public String bbs_kd_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_kd_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_kd_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_kd_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_kd_authorInfo", JSON.toJSON((KdnetAuthorEntity)bbs_kd_authorInfo));
        model.addAttribute("bbs_kd_postInfo", JSON.toJSON((KdnetPostEntity)bbs_kd_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("bbs_xinhua_posttitle")
    public String bbs_xinhua_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_xinhua_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object bbs_xinhua_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object bbs_xinhua_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("bbs_xinhua_authorInfo", JSON.toJSON((XinhuaNewsEntity)bbs_xinhua_authorInfo));
        model.addAttribute("bbs_xinhua_postInfo", JSON.toJSON((XinhuaNewsEntity)bbs_xinhua_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("blog_163_posttitle")
    public String blog_163_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_163_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object blog_163_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object blog_163_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("blog_163_authorInfo", JSON.toJSON((Blog163AuthorEntity)blog_163_authorInfo));
        model.addAttribute("blog_163_postInfo", JSON.toJSON((Blog163PostEntity)blog_163_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }


    @RequestMapping("blog_china_posttitle")
    public String blog_china_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_china_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object blog_china_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object blog_china_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("blog_china_authorInfo", JSON.toJSON((BlogchinaAuthorEntity)blog_china_authorInfo));
        model.addAttribute("blog_china_postInfo", JSON.toJSON((BlogchinaBlogEntity)blog_china_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

    @RequestMapping("blog_sina_posttitle")
    public String blog_sina_posttitle(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_sina_posttitle";
        String authorID = req.getParameter("authorID");
        String postID = req.getParameter("postID");

        Object blog_sina_authorInfo = authorService.getAuthorInfo(authorID,type_to_tableName(type));
        Object blog_sina_postInfo = postService.getPostInfo(authorID,postID,type_to_tableName(type));

        model.addAttribute("authorID",authorID);
        model.addAttribute("blog_sina_authorInfo", JSON.toJSON((BlogSinaAuthorEntity)blog_sina_authorInfo));
        model.addAttribute("blog_sina_postInfo", JSON.toJSON((BlogSinaPostEntity)blog_sina_postInfo));
        model.addAttribute("postList", JSON.toJSON(postList(req,type)));
        return "posttitle_display";
    }

}
