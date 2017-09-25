package com.sicdlib.controller;

import com.alibaba.fastjson.JSON;
import com.sicdlib.util.HBaseUtil.HBPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CommentController {

    @RequestMapping("bbs_china_comment")
    public String bbs_china_comment(HttpServletRequest req, Model model, HttpServletResponse resp) {

        String type = "bbs_china_comment";

//        model.addAttribute(type, JSON.toJSON(getAuthorList(req,type,pageInfo)));
        return "author_display";
    }
}
