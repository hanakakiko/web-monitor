package com.dingjiangying.webmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    CommonController commonController;

    @RequestMapping("/list")
    public String getGreenPage(Model model){
//        commonController.putUserName(model);
        return "alert";
    }

}
