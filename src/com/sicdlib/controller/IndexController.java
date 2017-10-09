package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.service.IArticleSimiService;
import com.sicdlib.service.hbaseService.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    @Qualifier("articleSimiService")
    private IArticleSimiService articleSimiService;

    @Autowired
    @Qualifier("authorService")
    private IAuthorService authorService;

    @RequestMapping("setSimi")
    public void setAuthor(HttpServletRequest req) throws Exception {
        String eventID = req.getParameter("eventID");

        articleSimiService.setEventArticleSimi(eventID);
    }

    @RequestMapping("authorIndex")
    public String showAuthorIndex(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
        String eventID = req.getParameter("eventID");

        Map<String, Map> result = new HashMap<>();

        if (eventID != null && !eventID.equals("")) {
            result = authorService.getAuthorInfluenceAndActiveness(eventID);
        }

        model.addAttribute("eventID", eventID);
        model.addAttribute("influenceAndActiveness", JSON.toJSON(result));

        return "author_index";
    }
}
