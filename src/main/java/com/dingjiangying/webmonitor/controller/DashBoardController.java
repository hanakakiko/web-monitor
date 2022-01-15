package com.dingjiangying.webmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @RequestMapping("/summury")
    public String getGreenPage(){
        return "monitor";
    }

}
