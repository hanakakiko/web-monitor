package com.dingjiangying.webmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping("/info")
    public String getGreenPage(){
        return "alert";
    }

}
