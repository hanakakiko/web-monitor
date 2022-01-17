package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.TaskMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskPoMapper taskMapper;

    @Autowired
    CommonController commonController;

    @GetMapping("/list")
    public String getTaskList(Model model, HttpSession session) {
//        taskMapper.
//        List<TaskPo> tasks = taskMapper.getTasks();
//        model.addAttribute("tasks", tasks);
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
//        commonController.putUserName(model);
        return "task";
    }
//
//    // 查询全部部门
//    @GetMapping("/detail/{id}")
//    public TaskPo getDepartment(@PathVariable("id") String id){
//        return taskMapper.getTask(id);
//    }

}
