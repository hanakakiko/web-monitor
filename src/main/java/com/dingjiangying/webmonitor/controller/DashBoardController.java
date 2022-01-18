package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    CommonController commonController;

    @RequestMapping("/summury")
    public String getGreenPage(Model model, HttpSession session){
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        return "monitor";
    }

}
