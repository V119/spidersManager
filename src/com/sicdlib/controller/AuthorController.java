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

    public List getMoeAuthorList(HttpServletRequest req,String type,HBPage page,String condition){
        return authorService.getMoeAuthorList(type,page,condition);
    }

    List savePageEntityList = new ArrayList();

    public HBPage pageInfo(HttpServletRequest req,Boolean isNewPage){
        HBPage pageInfo = new HBPage();
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        String prePage = req.getParameter("prePage");
        String nextPage = req.getParameter("nextPage");
        String rowKeyEndNum = "";
        String rowKeyBeginNum = "";
        String objectType = req.getParameter("type");

        pageInfo.setObjectType(objectType);
        if (isNewPage == true){
            for(int i = 0; i<savePageEntityList.size();i++) {
                HBPage hb = (HBPage) savePageEntityList.get(i);
                if ((hb.getPageIndex() == pageIndex-1)&&(hb.getObjectType().equals(objectType))){
                    rowKeyBeginNum = hb.getRowKeyBeginNum();
                    rowKeyEndNum = hb.getRowKeyEndNum();
                    break;
                }
            }
        }
        if (isNewPage == false){
            for(int i = 0; i<savePageEntityList.size();i++) {
                HBPage hb = (HBPage) savePageEntityList.get(i);
                if ((hb.getPageIndex() == pageIndex)&&(hb.getObjectType().equals(objectType))){
                    rowKeyBeginNum = hb.getRowKeyBeginNum();
                    rowKeyEndNum = hb.getRowKeyEndNum();
                    break;
                }
            }
        }
        pageInfo.setRowKeyBeginNum(rowKeyBeginNum);
        pageInfo.setRowKeyEndNum(rowKeyEndNum);
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageInfo.getPageSize());

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
        String condition = req.getParameter("condition");
        String rowKeyBeginNum = " ";
        String rowKeyEndNum = " ";
        List getAuthorList = new ArrayList();

        if (condition==null)
            condition = " ";
        HBPage hbpage = new HBPage();
        if (pageIndex==1){
            if ("xinhua_news".equals(type)||"moe_news".equals(type)){
                getAuthorList = getMoeAuthorList(req,type,pageInfo(req,false),condition);
            }else {
                getAuthorList = getAuthorList(req,type,pageInfo(req,false));
            }
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
            boolean isSave = false;
            for(int i = 0; i<savePageEntityList.size();i++) {
                HBPage hbPage = (HBPage) savePageEntityList.get(i);
                if (pageIndex == hbPage.getPageIndex()&&hbPage.getObjectType().equals(type)) {
                    isSave = true;
                    hbpage.setPageIndex(pageIndex);
                    break;
                }
            }
            if (isSave == false){
                hbpage.setObjectType(type);
                hbpage.setPageIndex(pageIndex);
                hbpage.setRowKeyBeginNum(rowKeyBeginNum);
                hbpage.setRowKeyEndNum(rowKeyEndNum);
                savePageEntityList.add(hbpage);
            }


        }
        if (pageIndex>1){
            boolean flag = false;

            for(int i = 0; i<savePageEntityList.size();i++) {
                HBPage hbPage = (HBPage) savePageEntityList.get(i);
                if (pageIndex == hbPage.getPageIndex()&&hbPage.getObjectType().equals(type)) {
                    hbPage.setPrePage(0);
                    flag = true;
                    getAuthorList = getAuthorList(req, type, hbPage);
                    break;
                }
            }
            hbpage.setPageIndex(pageIndex);
            if (flag == false) {
                if ("xinhua_news".equals(type)||"moe_news".equals(type)){
                    getAuthorList = getMoeAuthorList(req,type,pageInfo(req,true),condition);
                }else {
                    getAuthorList = getAuthorList(req,type,pageInfo(req,true));
                }
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

                boolean isSave = false;
                for(int i = 0; i<savePageEntityList.size();i++) {
                    HBPage hbPage = (HBPage) savePageEntityList.get(i);
                    if (pageIndex == hbPage.getPageIndex()&&hbPage.getObjectType().equals(type)) {
                        isSave = true;
                        break;
                    }
                }
                if (isSave == false){
                    hbpage.setObjectType(type);
                    hbpage.setPageIndex(pageIndex);
                    hbpage.setRowKeyBeginNum(rowKeyBeginNum);
                    hbpage.setRowKeyEndNum(rowKeyEndNum);
                    savePageEntityList.add(hbpage);
                }
            }
        }

        model.addAttribute("type",type);
        model.addAttribute("page",hbpage);
        model.addAttribute(type, JSON.toJSON(getAuthorList));
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
        HBPage hbpage = new HBPage();
        if (pageIndex<=1){

            getAuthorList = getMoeAuthorList(req,type,pageInfo(req,false),condition);

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


            getAuthorList = getMoeAuthorList(req,type,pageInfo(req,true),condition);

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
*/


}
