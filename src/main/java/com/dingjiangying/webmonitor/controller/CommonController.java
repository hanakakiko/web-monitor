package com.dingjiangying.webmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

    @RequestMapping("login")
    public String getLogin(){
        return "/login";
    }

    @RequestMapping("login?{param}")
    public String getLogin(@PathVariable("param") String param, Model model){
        model.addAttribute("param", param);
        return "/login";
    }

}
