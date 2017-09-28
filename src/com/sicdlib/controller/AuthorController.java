package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.hbaseService.imple.AuthorService;
import com.sicdlib.util.HBaseUtil.HBPage;
import com.sicdlib.util.HBaseUtil.PageInfo;
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

/**
 * 数据库中没有相对应的表bbs_xici_author ,bbs xinhua 网的作者表
 */
@Controller
public class AuthorController {

    @Autowired
    @Qualifier("authorService")
    private AuthorService authorService;



    public List getAuthorList(HttpServletRequest req,String type,HBPage page){
        return authorService.getAuthorList(type,page);
    }

//    public List getAuthorList(HttpServletRequest req,String type,HBPage page){
//        return authorService.getAuthorList(type,page,pageEntityList);
//    }

    public List getMoeAuthorList(HttpServletRequest req,String type,HBPage page,String condition){
        return authorService.getMoeAuthorList(type,page,condition);
    }

    List savePageEntityList = new ArrayList();

    public HBPage pageInfo(HttpServletRequest req,Boolean isNewPage){
        HBPage pageInfo = new HBPage();
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        String prePage = req.getParameter("prePage");
        String nextPage = req.getParameter("nextPage");
        String rowKeyEndNum = req.getParameter("rowKeyEndNum");
        String rowKeyBeginNum=req.getParameter("rowKeyBeginNum");

        if (isNewPage == true){
            for(int i = 0; i<savePageEntityList.size();i++) {
                HBPage hb = (HBPage) savePageEntityList.get(i);
                if (hb.getPageIndex() == pageIndex-1){
                    rowKeyBeginNum = hb.getRowKeyBeginNum();
                    rowKeyEndNum = hb.getRowKeyEndNum();
                }
            }
        }
        pageInfo.setRowKeyBeginNum(rowKeyBeginNum);
        pageInfo.setRowKeyEndNum(rowKeyEndNum);
        //设置当前页
        if (pageIndex <1){
            pageIndex =1;
        }
        pageInfo.setPageIndex(pageIndex);

        //设置页面大小----开始

        pageInfo.setPageSize(pageInfo.getPageSize());
        //设置页面大小----结束

        //是否点击前一页---开始
        int prePages = 0;
        if(prePage==" "||prePage==null||pageIndex==1){
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
    @RequestMapping("bbs_author")
    public String bbs_china_anthor(HttpServletRequest req, Model model, HttpServletResponse resp) {
//        List savePageEntityList = new ArrayList();
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        //*********************************
        String type = req.getParameter("type");
        String rowKeyBeginNum = " ";
        String rowKeyEndNum = " ";
        List getAuthorList = new ArrayList();

        if (pageIndex<1){
           pageIndex=1;
        }
        HBPage hbpage = new HBPage();
        if (pageIndex==1){

            getAuthorList = getAuthorList(req,type,pageInfo(req,false));
            String pk0 = getAuthorList.get(0).toString();
            String pk1 = getAuthorList.get(getAuthorList.size()-1).toString();
            String rgex = "pk='(.*?)'";
            Pattern pattern = Pattern.compile(rgex);// 匹配的模式
            Matcher m0 = pattern.matcher(pk0);
            Matcher m1 = pattern.matcher(pk1);
            while (m0.find()) {
                System.out.println("m0group(1):"+m0.group(1));
                rowKeyBeginNum = m0.group(1).toString();
            }
            while (m1.find()) {
                System.out.println("m1group(1):"+m1.group(1));
                rowKeyEndNum = m1.group(1).toString();
            }

            hbpage.setPageIndex(pageIndex);
            hbpage.setRowKeyBeginNum(rowKeyBeginNum);
            hbpage.setRowKeyEndNum(rowKeyEndNum);
            savePageEntityList.add(hbpage);
        }
        if (pageIndex>1){
            boolean flag = false;

            for(int i = 0; i<savePageEntityList.size();i++) {
                HBPage hbPage = (HBPage) savePageEntityList.get(i);

                if (pageIndex == hbPage.getPageIndex()) {
                    hbPage.setPrePage(0);
                    flag = true;

                    getAuthorList = getAuthorList(req, type, hbPage);
                    break;
                }
            }
            hbpage.setPageIndex(pageIndex);
            if (flag == false) {

                getAuthorList = getAuthorList(req, type, pageInfo(req,true));
                //截取pk的值
                String pk0 = getAuthorList.get(0).toString();
                String pk1 = getAuthorList.get(getAuthorList.size() - 1).toString();
                String rgex = "pk='(.*?)'";
                Pattern pattern = Pattern.compile(rgex);// 匹配的模式
                Matcher m0 = pattern.matcher(pk0);
                Matcher m1 = pattern.matcher(pk1);
                while (m0.find()) {
                    System.out.println("m0group(1):" + m0.group(1));
                    rowKeyBeginNum = m0.group(1).toString();
                }
                while (m1.find()) {
                    System.out.println("m1group(1):" + m1.group(1));
                    rowKeyEndNum = m1.group(1).toString();
                }


                hbpage.setPageIndex(pageIndex);
                hbpage.setRowKeyBeginNum(rowKeyBeginNum);
                hbpage.setRowKeyEndNum(rowKeyEndNum);
                savePageEntityList.add(hbpage);
            }
        }

        model.addAttribute("type",type);
        model.addAttribute("page",hbpage);
        model.addAttribute(type, JSON.toJSON(getAuthorList));
        model.addAttribute("rowKeyBeginNum",rowKeyBeginNum);
        model.addAttribute("rowKeyEndNum",rowKeyEndNum);
        return "author_display";
    }

    /*@RequestMapping("news")
    public String news(HttpServletRequest req, Model model, HttpServletResponse resp) {

        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        //*********************************
        String type = req.getParameter("type");
        String condition = req.getParameter("condition");

        String rowKeyBeginNum = " ";
        String rowKeyEndNum = " ";
        List getAuthorList = new ArrayList();
        List<PageInfo> savePageEntityList = new ArrayList<>();
        if (pageIndex<1){
            pageIndex=1;
        }
        if (pageIndex==1){
            PageInfo newPage = new PageInfo();
            getAuthorList = getMoeAuthorList(req,type,pageInfo(req),condition);

            newPage.setPageIndex(pageIndex);
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

                newPage.setPageBeginNum(rowKeyBeginNum);
            }
            while (m1.find()) {
                System.out.println("m1group(1):"+m1.group(1));
                rowKeyEndNum = m1.group(1).toString();
                pageInfo(req).setRowKeyEndNum(rowKeyEndNum);
                newPage.setPageEndNum(rowKeyEndNum);
            }
            savePageEntityList.add(newPage);
        }
        if (pageIndex>1){
            PageInfo newPage = new PageInfo();
            newPage.setPageIndex(pageIndex);
            rowKeyEndNum = req.getParameter("rowKeyEndNum");
            rowKeyBeginNum=req.getParameter("rowKeyBeginNum");
//            getAuthorList = getAuthorList(req,type,pageInfo(req),);

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
                pageInfo(req).setRowKeyBeginNum(rowKeyBeginNum);
                newPage.setPageBeginNum(rowKeyBeginNum);
            }
            while (m1.find()) {
                System.out.println("m1group(1):"+m1.group(1));
                rowKeyEndNum = m1.group(1).toString();
                pageInfo(req).setRowKeyBeginNum(rowKeyBeginNum);
                newPage.setPageEndNum(rowKeyEndNum);
            }
            savePageEntityList.add(newPage);
        }


        //**********************************
        *//*if (nextflag==" "||nextflag==null){

            getAuthorList = getAuthorList(req,type,pageInfo(req));
            nextflag = "0";

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
            }
            while (m1.find()) {
                System.out.println("m1group(1):"+m1.group(1));
                rowKeyEndNum = m1.group(1).toString();
            }

        }
        model.addAttribute("type",type);
        model.addAttribute("page",pageInfo(req));
        model.addAttribute("newPage",newPage);
        model.addAttribute(type, JSON.toJSON(getAuthorList));
        model.addAttribute("rowKeyBeginNum",rowKeyBeginNum);
        model.addAttribute("rowKeyEndNum",rowKeyEndNum);*//*
        model.addAttribute("type",type);
        model.addAttribute("page",pageInfo(req));
        model.addAttribute("savePageEntityList",savePageEntityList);
        model.addAttribute(type, JSON.toJSON(getAuthorList));
        model.addAttribute("rowKeyBeginNum",rowKeyBeginNum);
        model.addAttribute("rowKeyEndNum",rowKeyEndNum);
        return "author_display";
    }*/



}
