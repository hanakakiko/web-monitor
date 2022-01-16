package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.UserMapper;
import com.dingjiangying.webmonitor.form.UserInfo;
import com.dingjiangying.webmonitor.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

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
        System.out.println("post!");
        UserPo userPo = userInfo.covertToPo();
        userMapper.insertUser(userPo);
        return "task";
    }

}
