package com.dingjiangying.webmonitor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class taskController {
    @RequestMapping("/create")
    public String createTask(){
        return "createTask";
    }
}
