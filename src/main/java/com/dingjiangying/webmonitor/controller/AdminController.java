package com.dingjiangying.webmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("createProbe")
    public String createProbe(){
        return "createProbe";
    }
}
