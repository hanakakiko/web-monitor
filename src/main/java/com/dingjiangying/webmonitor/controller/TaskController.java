package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.TaskMapper;
import com.dingjiangying.webmonitor.po.TaskPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/list")
    public String getTaskList(Model model){
        List<TaskPo> tasks = taskMapper.getTasks();
        model.addAttribute("tasks", tasks);
        return "task";
    }

    // 查询全部部门
    @GetMapping("/detail/{id}")
    public TaskPo getDepartment(@PathVariable("id") String id){
        return taskMapper.getTask(id);
    }

}
