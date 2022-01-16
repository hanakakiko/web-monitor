package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.UserMapper;
import com.dingjiangying.webmonitor.form.UserInfo;
import com.dingjiangying.webmonitor.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommonController commonController;

    @RequestMapping("login")
    public String getLogin(Model model){
        commonController.putUserName(model);
        return "/login";
    }

    @RequestMapping("login?{param}")
    public String getLogin(@PathVariable("param") String param, Model model){
        commonController.putUserName(model);
        model.addAttribute("param", param);
        return "/login";
    }

    @RequestMapping("/info")
    public String getGreenPage(){
        return "alert";
    }

    @RequestMapping("/register")
    public String register(){
        System.out.println("get!");
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(value = "userinfo") UserInfo userInfo, Model model){
        commonController.putUserName(model);
        System.out.println("post!");
        UserPo userPo = userInfo.covertToPo();
        userMapper.insertUser(userPo);
        return "task";
    }

    @RequestMapping("contact")
    public String showContact(){
        return "/login";
    }

}
