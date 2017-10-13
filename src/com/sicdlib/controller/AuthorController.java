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

    List savePageEntityList = new ArrayList();

    @RequestMapping("bbs_author")
    public String bbs_china_anthor(HttpServletRequest req, Model model, HttpServletResponse resp) {
        HBPage hbpage = new HBPage();
        List getAuthorList = new ArrayList();
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        String type = req.getParameter("type");
        hbpage.setPageIndex(pageIndex);
        //查询的数据是否已经保存，初始化时默认未保存，如果内存中已经有数据，则修改状态标记为true，并从已有数据中查询
        boolean flag = false;
        for(int i = 0; i<savePageEntityList.size();i++) {
            HBPage hbPage = (HBPage) savePageEntityList.get(i);
            if (pageIndex == hbPage.getPageIndex()&&hbPage.getObjectType().equals(type)) {
                hbPage.setPrePage(0);
                flag = true;
                getAuthorList = getAuthorList(type,hbPage);
                break;
            }
        }
        //查询的数据没有保存过，查询信息，并保存当前页面信息
        if (flag == false) {
            if(pageIndex==1)
                getAuthorList = getAuthorList(type,pageInfo(req,false));
            else
                getAuthorList = getAuthorList(type,pageInfo(req,true));
            hbpage.setObjectType(type);
            hbpage.setPageIndex(pageIndex);
            hbpage.setRowKeyBeginNum(getFirstAndEndNum(getAuthorList).getRowKeyBeginNum());
            hbpage.setRowKeyEndNum(getFirstAndEndNum(getAuthorList).getRowKeyEndNum());
            savePageEntityList.add(hbpage);
        }
        model.addAttribute("type",type);
        model.addAttribute("page",hbpage);
        model.addAttribute(type, JSON.toJSON(getAuthorList));
        return "author_display";
    }

    public List getAuthorList(String type,HBPage page){
        return authorService.getAuthorList(type,page);
    }

    //保存页面信息
    public HBPage pageInfo(HttpServletRequest req,Boolean isNewPage){
        HBPage pageInfo = new HBPage();
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        String objectType = req.getParameter("type");
        String prePage = req.getParameter("prePage");
        String nextPage = req.getParameter("nextPage");
        String rowKeyEndNum = " ";
        String rowKeyBeginNum = " ";
        int prePages = 0;
        int nextPages = 0;

        prePages = (prePage==" "||prePage==null||pageIndex==1)? pageInfo.getPrePage():Integer.parseInt(prePage);
        nextPages = (nextPage==" "||nextPage==null)?pageInfo.getNextPage():Integer.parseInt(nextPage);
        int currentPageIndex = (isNewPage == true)?pageIndex-1:pageIndex;
        for(int i = 0; i<savePageEntityList.size();i++) {
            HBPage hb = (HBPage) savePageEntityList.get(i);
            if ((hb.getPageIndex() == currentPageIndex)&&(hb.getObjectType().equals(objectType))){
                rowKeyBeginNum = hb.getRowKeyBeginNum();
                rowKeyEndNum = hb.getRowKeyEndNum();
                break;
            }
        }
        pageInfo.setPrePage(prePages);
        pageInfo.setNextPage(nextPages);
        pageInfo.setObjectType(objectType);
        pageInfo.setRowKeyBeginNum(rowKeyBeginNum);
        pageInfo.setRowKeyEndNum(rowKeyEndNum);
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageInfo.getPageSize());
        return pageInfo;
    }

    //获取当前页的第一条数据和最后一条数据的编号
    public HBPage getFirstAndEndNum(List authorList){
        HBPage hbPage = new HBPage();
        String first = authorList.get(0).toString();
        String last = authorList.get(authorList.size()-1).toString();
        String rgex = "pk='(.*?)'";
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m0 = pattern.matcher(first);
        Matcher m1 = pattern.matcher(last);
        while (m0.find()) {
            hbPage.setRowKeyBeginNum(m0.group(1).toString());
        }
        while (m1.find()) {
            hbPage.setRowKeyEndNum(m1.group(1).toString());
        }
        return hbPage;
    }
}
