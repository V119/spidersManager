package com.sicdlib.controller;

import com.sicdlib.dto.TbEventArticleEntity;
import com.sicdlib.dto.TbEventEntity;
import com.sicdlib.dto.UserEntity;
import com.sicdlib.service.IEventArticleService;
import com.sicdlib.service.IEventService;
import com.sicdlib.service.ILoginService;

import com.sicdlib.util.MD5Util.MD5Util;
import com.sicdlib.util.MD5Util.RandNumUtil;
import com.sicdlib.util.SMSUtil.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    private ILoginService loginService;

    @Autowired
    @Qualifier("eventService")
    private IEventService eventService;

    @Autowired
    @Qualifier("eventArticleService")
    private IEventArticleService eventArticleService;

    /**
     * 用户的登陆
     * @param req
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("login")
    public String login(HttpServletRequest req, Model model) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserEntity user = loginService.validateLogin(username, password);
        if (user != null){
            req.getSession().setAttribute("user", user);
            //获得所有事件信息
            List<TbEventEntity> events = eventService.getAllEvent();
            //添加事件中文章的热度
            for (int i = 0; i < events.size(); i ++){
                String eventID = events.get(i).getId();
                List<TbEventArticleEntity> eventArticles = eventArticleService.getEventArticleByEventID(eventID);
            }
            model.addAttribute("events", events);
            return "eventList_new";
        }
        return "redirect:failure.jsp";
    }

    /**
     * 用户登陆验证
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("validate_login")
    public void validate_login(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserEntity user = loginService.validateLogin(username, password);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if(user != null) {
            out.print("success");

        }else{
            out.print("faliure");
        }
        out.flush();
        out.close();
    }

    /**
     * 通过邮箱验证用户是否存在
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("getUserByEmail")
    public void getUserByEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String email = req.getParameter("email");
        UserEntity user = loginService.getUserByEmail(email);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (user != null){
            out.print("success");
        }else{
            out.print("faliure");
        }
        out.flush();
        out.close();
    }

    /**
     * 用户注册
     * @param user
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("register")
    public String register(UserEntity user, HttpServletRequest req, HttpServletResponse resp){
        loginService.addUser(user);
        req.getSession().setAttribute("user", user);
        return "redirect:activation.jsp";
    }

    /**
     * 验证用户名是否存在
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("validate_usernameIsExist")
    public void validate_usernameIsExist(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String username = req.getParameter("username");
        UserEntity user = loginService.getUserByName(username);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if(user == null) {
            //说明用户不存在
            out.print("success");
        }
        out.flush();
        out.close();
    }

    /**
     * 发送邮箱验证链接
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("sendMailValidation")
    public String sendMailValidation(HttpServletRequest req, HttpServletResponse resp){
        UserEntity user = (UserEntity) req.getSession().getAttribute("user");
        //得到8位随机验证码
        String validateCode = RandNumUtil.getRandNum(8);
        req.getSession().setAttribute("validateCode", validateCode);
        String validateCodeMD5 = MD5Util.generatePassword(validateCode);
        String content = "点击下面链接激活账号，30分钟生效，否则重新注册账号，链接只能使用一次，请尽快激活！";
        String url = "http://localhost:8080/spidersmanager/emailActivation";
        loginService.emailActivation(user, validateCodeMD5, content, url);
        return "redirect:success.jsp";
    }

    /**
     * 验证发送的邮箱验证码
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("emailActivation")
    public String emailActivation(HttpServletRequest req, HttpServletResponse resp){
        String validateCodeMD5 = req.getParameter("validateCode");
        String validateCode = (String)req.getSession().getAttribute("validateCode");
        if (validateCodeMD5.equals(MD5Util.generatePassword(validateCode))){
            //添加一个激活成果标识

            return "index";
        }else{
            return "redirect:failure.jsp";
        }
    }

    /**
     * 发送手机验证码
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("telephoneActivation")
    public void telephoneActivation(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int mobile_code = 0;
        String telephone = req.getParameter("telephone");
        //发送手机验证码
        mobile_code = SMSUtil.SendSMS(telephone);
        req.getSession().setAttribute("mobile_code", mobile_code);
        //req.getSession().setAttribute("mobile_code", 123);
        Date dt =new Date();
        req.getSession().setAttribute("mobile_code_genetime", dt.getTime());
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("success");
        out.flush();
        out.close();
    }

    /**
     * 验证手机验证码
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("valid_mobile_code")
    public void valid_mobile_code(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String mobile_code = req.getParameter("mobile_code");
        String gene_mobile_code = req.getSession().getAttribute("mobile_code").toString();
        Long mobile_code_genetime = Long.valueOf(req.getSession().getAttribute("mobile_code_genetime").toString());
        int interval_time = (int)(new Date().getTime()-mobile_code_genetime)/1000;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if(interval_time < 180 && mobile_code.equals(gene_mobile_code)){
            out.print("success");
        }else{
            out.print("failure");
        }
        out.flush();
        out.close();
    }

    /**
     * 在重置密码中，发送邮箱验证链接
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("findPassword_sendMail")
    public void findPassword_sendMail(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String email = req.getParameter("email");
        //通过邮箱得到用户
        UserEntity user = loginService.getUserByEmail(email);
        //得到8位随机验证码
        String validateCode = RandNumUtil.getRandNum(8);
        req.getSession().setAttribute("validateCode", validateCode);
        String validateCodeMD5 = MD5Util.generatePassword(validateCode);
        String content = "点击下面链接重置密码，30分钟生效，否则无法重置密码，链接只能使用一次，请尽快重置！";
        String url = "http://localhost:8080/spidersmanager/resetPassword";
        //发送验证码到邮箱
        loginService.emailActivation(user, validateCodeMD5, content, url);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("success");
        out.flush();
        out.close();
    }

    /**
     * 在重置密码中，验证邮箱
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("resetPassword")
    public String resetPassword(HttpServletRequest req, HttpServletResponse resp){
        String email = req.getParameter("email");
        req.getSession().setAttribute("email", email);
        UserEntity user = loginService.getUserByEmail(email);
        String validateCode_from_emailMD5 = req.getParameter("validateCode");
        String validateCode = "";
        if(req.getSession().getAttribute("validateCode") != null){
            validateCode = req.getSession().getAttribute("validateCode").toString();
        }
        String validateCodeMD5 = MD5Util.generatePassword(validateCode);

        if(validateCode_from_emailMD5.equals(validateCodeMD5)&& user != null){
            return "redirect:resetPassword.jsp";
        }else{
            return "redirect:failure.jsp";
        }
    }

    /**
     * 重置密码，保存数据库
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("resetPassword_action")
    public String resetPassword_action(HttpServletRequest req, HttpServletResponse resp){
        String password = req.getParameter("password");
        String email = req.getSession().getAttribute("email").toString();
        UserEntity user = loginService.getUserByEmail(email);
        user.setPasswd(password);
        //保存
        loginService.addUser(user);
        return "redirect:success.jsp";
    }

    /**
     * 用户注销登录
     * @param req
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute("user");
        System.out.println("logout");
        return "redirect:/";
    }
}