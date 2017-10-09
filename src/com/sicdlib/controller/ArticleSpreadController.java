package com.sicdlib.controller;

import com.sicdlib.service.IArticleSpreadService;
import com.sicdlib.service.IWebsiteService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.serializer.SerializerFeature;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/6.
 */
@Controller
public class ArticleSpreadController {
    @Autowired
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @Autowired
    @Qualifier("articleSpreadService")
    private IArticleSpreadService articleSpreadService;

    @RequestMapping("articleSpread")
    public String articleSpread(HttpServletRequest req, Model model) {
        String eventID = req.getParameter("eventID");

        List<String> categoryName = websiteService.getWebsiteNameByEvent(eventID);

        Map<String, List> nodesAndEdges = articleSpreadService.getNodeAndEdgeAttributes(eventID);


        List<Object> SNAList=articleSpreadService.getSNA(nodesAndEdges.get("nodes"),nodesAndEdges.get("edges"));

        //   Map<Object,Object> SNA=articleSpreadService.getSNA2(nodesAndEdges.get("nodes"),(List)nodesAndEdges.get("edges").get(2));


        model.addAttribute("category", JSON.toJSONString(categoryName).replace("'", "\\\'"));
        model.addAttribute("nodesAndEdges", JSON.toJSONString(nodesAndEdges)
                .replace("'", "\\\'"));
        model.addAttribute("eventID", eventID);

        model.addAttribute("SNAList", JSON.toJSONString(SNAList, SerializerFeature.DisableCircularReferenceDetect));//各个阈值下的SNA参数列表

        //  model.addAttribute("SNA", JSON.toJSONString(SNA));//SNA参数列表

        return "article_spread3";
    }

    @RequestMapping("tooltipContent")
    public void tooltipContent(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String tableName = req.getParameter("table");
        String articleID = req.getParameter("articleID");
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        res.setHeader("Cache-Control", "no-cache");

        String content = articleSpreadService.getArticleContent(articleID, tableName);

        PrintWriter out = res.getWriter();

        out.print(content);
    }
}
