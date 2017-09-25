package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.hbaseService.imple.AuthorService;
import com.sicdlib.util.HBaseUtil.HBPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AuthorController {

    @Autowired
    @Qualifier("authorService")
    private AuthorService authorService;



    public List getAuthorList(HttpServletRequest req,String type,HBPage page,String rowKeyEndNum,String rowKeyBeginNum){
        return authorService.getAuthorList(type,page,rowKeyEndNum,rowKeyBeginNum);
    }
    public List getAuthorList(HttpServletRequest req,String type,HBPage page){
        return authorService.getAuthorList(type,page);
    }

    public HBPage pageInfo(HttpServletRequest req){
        HBPage pageInfo = new HBPage();
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        String pageSize = req.getParameter("pageSize");
        String prePage = req.getParameter("prePage");
        String nextPage = req.getParameter("nextPage");
        String rowKeyEndNum = req.getParameter("rowKeyEndNum");
        String rowKeyBeginNum=req.getParameter("rowKeyBeginNum");

        pageInfo.setRowKeyBeginNum(rowKeyBeginNum);
        pageInfo.setRowKeyEndNum(rowKeyEndNum);
        //设置当前页
        if (pageIndex <1){
            pageIndex =1;
        }
        pageInfo.setPageIndex(pageIndex);

        //设置页面大小----开始
        int pageSizes = 0;
        if (pageSize==" "||pageSize==null){
            pageSizes = pageInfo.getPageSize();
        }else{
            pageSizes = Integer.parseInt(pageSize);
        }
        pageInfo.setPageSize(pageSizes);
        //设置页面大小----结束

        //是否点击前一页---开始
        int prePages = 0;
        if(prePage==" "||prePage==null){
            prePages = pageInfo.getPrePage();
        }else {
            prePages = Integer.parseInt(prePage);
        }
        pageInfo.setPrePage(prePages);
        //是否点击前一页---结束

        //是否点击下一页---开始
        int nextPages = 0;
        if(nextPage==" "||nextPage==null){
            nextPages = pageInfo.getNextPage();
        }else {
            nextPages = Integer.parseInt(nextPage);
        }
        pageInfo.setNextPage(nextPages);
        return pageInfo;
        //是否点击下一页---结束
    }
    @RequestMapping("bbs_china_author")
    public String bbs_china_anthor(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_china_author";

        String nextflag = req.getParameter("flag");
        String rowKeyBeginNum = " ";
        String rowKeyEndNum = " ";
        List getAuthorList = new ArrayList();
        if (nextflag==" "||nextflag==null){

            getAuthorList = getAuthorList(req,type,pageInfo(req));
            nextflag = "0";
            System.out.println("这里要输出第一条信息的内容"+getAuthorList.get(0).toString());
            System.out.println("这里要输出最后一条信息的内容"+getAuthorList.get(getAuthorList.size()-1).toString());

            String pk0 = getAuthorList.get(0).toString();
            String pk1 = getAuthorList.get(getAuthorList.size()-1).toString();
            String rgex = "pk='(.*?)'";
            Pattern pattern = Pattern.compile(rgex);// 匹配的模式
            Matcher m0 = pattern.matcher(pk0);
            Matcher m1 = pattern.matcher(pk1);
            while (m0.find()) {
                System.out.println("m0group(1):"+m0.group(1));
                rowKeyBeginNum = m0.group(1).toString();
                pageInfo(req).setRowKeyBeginNum(rowKeyBeginNum);
            }
            while (m1.find()) {
                System.out.println("m1group(1):"+m1.group(1));
                rowKeyEndNum = m1.group(1).toString();
                pageInfo(req).setRowKeyEndNum(rowKeyEndNum);
            }
        }
        else {
            rowKeyEndNum = req.getParameter("rowKeyEndNum");

            rowKeyBeginNum=req.getParameter("rowKeyBeginNum");

            getAuthorList = getAuthorList(req,type,pageInfo(req),rowKeyEndNum,rowKeyBeginNum);
            System.out.println("这里要输出第一条信息的内容"+getAuthorList.get(0).toString());
            //截取pk的值
            String pk0 = getAuthorList.get(0).toString();
            String pk1 = getAuthorList.get(getAuthorList.size()-1).toString();
            String rgex = "pk='(.*?)'";
            Pattern pattern = Pattern.compile(rgex);// 匹配的模式
            Matcher m0 = pattern.matcher(pk0);
            Matcher m1 = pattern.matcher(pk1);
            while (m0.find()) {
                System.out.println("m0group(1):"+m0.group(1));
                rowKeyBeginNum = m0.group(1).toString();
//                pageInfo(req).setRowKeyBeginNum(rowKeyBeginNum);
            }
            while (m1.find()) {
                System.out.println("m1group(1):"+m1.group(1));
                rowKeyEndNum = m1.group(1).toString();
//                pageInfo(req).setRowKeyEndNum(rowKeyEndNum);
            }

        }
        model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList));
        model.addAttribute("rowKeyBeginNum",rowKeyBeginNum);
        model.addAttribute("rowKeyEndNum",rowKeyEndNum);
        /**
         * 从前台页面获得一个信号，如果没有信号，则默认查询第一页，select * from 表 limit 100；
         * 如果有信号，开始记录本页的最后一行数据的rowkeynum，然后 select * from 表 where rowkeynum > * limit 100
         */

       /* model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo(req),rowKeyNum)));*/
        return "author_display";
    }

    /*@RequestMapping("bbs_mop_author")
    public String bbs_mop_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_mop_author";
        model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo(req))));
        return "author_display";
    }


    @RequestMapping("bbs_people_author")
    public String bbs_people_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_people_author";
        model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo(req))));
        return "author_display";
    }

    @RequestMapping("bbs_sohu_author")
    public String bbs_sohu_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_sohu_author";
        model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo(req))));
        return "author_display";
    }

    @RequestMapping("bbs_tianya_author")
    public String bbs_tianya_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "bbs_tianya_author";
        model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo(req))));
        return "author_display";
    }

    @RequestMapping("kdnet_author")
    public String bbs_kd_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "kdnet_author";
        model.addAttribute("page",pageInfo(req));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo(req))));
        return "author_display";
    }*/
/*
    @RequestMapping("blog_163_author")
    public String blog_163_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_163_author";
//        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("blog_china_author")
    public String blog_china_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_china_author";
//        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }

    @RequestMapping("blog_sina_author")
    public String blog_sina_author(HttpServletRequest req, Model model, HttpServletResponse resp) {
        String type = "blog_sina_author";
//        model.addAttribute("page",page(req,type));
        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type)));
        return "author_display";
    }*/

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
