package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserPoMapper userPoMapper;
    @PostConstruct
    private void init(){
//        UserPo user=new UserPo();
//        user.setUserName("anyang");
//        user.setUserPassword("ay_pass");
//        userPoMapper.insert(user);
//        System.out.println("hello");
    }
//    @Autowired
//    UserPoMapper userMapper;
//
//    @RequestMapping("/info")
//    public String getGreenPage(){
//        return "alert";
//    }
//
//    @RequestMapping("/register")
//    public String register(){
//        System.out.println("get!");
//        return "register";
//    }
//
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("get!");
        return "register";
    }

//    @PostMapping("/register")
//    public String register(@ModelAttribute(value = "userinfo") UserInfo userInfo, Model model){
////        System.out.println("post!");
////        UserPo_backup userPoBackup = userInfo.covertToPo();
////        userMapper.insertUser(userPoBackup);
//        return "task";
//    }

}
