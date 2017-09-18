package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.dto.entity.*;
import com.sicdlib.service.imple.AuthorService;
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
public class AuthorController {

    @Autowired
    @Qualifier("authorService")
    private AuthorService authorService;

    public String type_to_tableName(String type){
        String tableName =null;
        if ("bbs_china_author".equals(type)){
            tableName = "BbsChinaAuthorEntity";
        }
        if ("bbs_mop_author".equals(type)){
            tableName = "BbsMopAuthorEntity";
        }
        if ("bbs_people_author".equals(type)){
            tableName = "BbsPeopleAuthorEntity";
        }
        if ("bbs_sohu_author".equals(type)){
            tableName = "BbsSohuAuthorEntity";
        }
        if ("bbs_tianya_author".equals(type)){
            tableName = "BbsTianyaAuthorEntity";
        }
        if ("bbs_xici_author".equals(type)){
            tableName = "BbsXiciAuthorEntity";
        }
        if ("bbs_kd_author".equals(type)){
            tableName = "KdnetAuthorEntity";
        }
        /*if ("bbs_xinhua_author".equals(type)){
            tableName = "XinhuaNewsEntity";
        }*/
        if ("blog_163_author".equals(type)){
            tableName = "Blog163AuthorEntity";
        }
        if ("blog_china_author".equals(type)){
            tableName = "BlogchinaAuthorEntity";
        }
        if ("blog_sina_author".equals(type)){
            tableName = "BlogSinaAuthorEntity";
        }

        return tableName;
    }

    public Page page(HttpServletRequest req,String type){

        int totalRecord = authorService.getAllAuthorNum(type_to_tableName(type));//总记录数
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));//当前页码
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));;//每页显示多少条
        return new Page(totalRecord, pageIndex, pageSize);
    }

    public List getAuthorList(HttpServletRequest req,String type){
        return authorService.getAuthorList(type_to_tableName(type),page(req,type));
    }

    @RequestMapping("bbs_china_author")
    public String bbs_china_anthor(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = "bbs_china_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("bbs_mop_author")
    public String bbs_mop_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_mop_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("bbs_people_author")
    public String bbs_people_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_people_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("bbs_sohu_author")
    public String bbs_sohu_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_sohu_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("bbs_tianya_author")
    public String bbs_tianya_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_tianya_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("bbs_kd_author")
    public String bbs_kd_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_kd_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("blog_163_author")
    public String blog_163_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_163_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("blog_china_author")
    public String blog_china_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_china_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("blog_sina_author")
    public String blog_sina_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_sina_author";
        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    /* @RequestMapping("bbs_xinhua_author")
   //数据库没有bbs xinhua 网的作者表
    public String bbs_xinhua_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_sohu_author";
        model.addAttribute("page",page(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(type)));
        return "author_display";
    }*/
     /*@RequestMapping("bbs_xici_author")
    //数据库中没有相对应的表
    public String bbs_xici_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_xici_author";
        model.addAttribute("page",page(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(type)));
        return "author_display";
    }*/

}
