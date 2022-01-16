package com.dingjiangying.webmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    CommonController commonController;

    @RequestMapping("createProbe")
    public String createProbe(){
        return "createProbe";
    }
}
