package com.sicdlib.controller;


import com.google.gson.Gson;
import com.sicdlib.service.ICalendarService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//数据清洗
@Controller
public class CalendarController {
    @Autowired
    @Qualifier("calendarService")
    private ICalendarService calendarService;

    @RequestMapping("TableServerlet")
    public void tbForm(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        request.setCharacterEncoding("UTF-8");//传值编码
        response.setCharacterEncoding("UTF-8");
//        获取到表的名字
        String tablename =request.getParameter("tablename");
        //获取thead和tbody的值
        List<String> tHeadValue = calendarService.getThead(tablename);
        List<String> tBodyValue = calendarService.getTbody(tablename);
//        model.addAttribute("tHeadValue",tHeadValue);
//        model.addAttribute("tbodyvalue",tbodyvalue);
        System.out.println("返回到controller:"+tHeadValue);
        PrintWriter out=response.getWriter();       //向客户端发送字符数据
        response.setContentType("text/text");          //设置请求以及响应的内容类型以及编码方式
//    JSONArray json = JSONArray.fromObject(tHeadValue);   //将对象转换为json对象
//    String str = json.toString();                //将json对象转换为字符串
        Gson gson = new Gson();
        String strHead = gson.toJson(tHeadValue);
        String strBody = gson.toJson(tBodyValue.get(0))+"+"+gson.toJson(tBodyValue.get(2));
//        String str =strHead+"&"+strBody;
    out.write(strBody);                     //将str字符传输到前台
    }
}
