package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String getIndex(Model model, HttpSession session){
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
//        putUserName(model);
        return "index";
    }

    void putUserName(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            model.addAttribute("currentUser",currentUserName);
        }else{
            model.addAttribute("currentUser","游客");
        }
    }

}
