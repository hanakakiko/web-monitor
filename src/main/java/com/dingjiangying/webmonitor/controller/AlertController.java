package com.dingjiangying.webmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alert")
public class AlertController {

    @RequestMapping("/list")
    public String getGreenPage(){
        return "alert";
    }

}
