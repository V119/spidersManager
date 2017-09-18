package com.sicdlib.controller;

import com.sicdlib.service.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CleanDataController {
    @Autowired
    @Qualifier("websiteService")
    private IWebsiteService websiteService;

    @RequestMapping("clean_data")
    public String clean_data(HttpServletRequest req, Model model) {

        return "clean_data";
    }

    @RequestMapping("clean_data_display")
    public String clean_data_display(Model model) {

        return "clean_data_display";
    }

    @RequestMapping("post_comment_display")
    public String post_comment_display(Model model) {

        return "post_comment_display";
    }
}
