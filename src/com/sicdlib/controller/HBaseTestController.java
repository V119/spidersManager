package com.sicdlib.controller;

import com.sicdlib.dao.hbaseDAO.ITest;
import com.sicdlib.dto.phoenixEntity.SpiderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by haoyang on 2017/9/18.
 */
@Controller
public class HBaseTestController {
    @Autowired
    @Qualifier("hbaseTest")
    private ITest testDAO;

    @RequestMapping("hbaseTest")
    public void findValue(HttpServletRequest req, HttpServletResponse resp) {
        List<SpiderInfoEntity> spiderList = testDAO.getTestEntity();
//        model.addAttribute("list", spiderList);
        for(SpiderInfoEntity spiderInfo: spiderList) {
            System.out.println(spiderInfo.getPk());
        }

    }

}
