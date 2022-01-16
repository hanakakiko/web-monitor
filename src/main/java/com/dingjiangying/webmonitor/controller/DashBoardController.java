package com.dingjiangying.webmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    CommonController commonController;

    @RequestMapping("/summury")
    public String getGreenPage(){
        return "monitor";
    }

}
