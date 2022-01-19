package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.service.ScheduledProbeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProbeController {

    @Autowired
    private ScheduledProbeTaskService scheduledProbeTaskService;

    @Autowired
    CommonController commonController;

    @GetMapping("/pulltask/{probe_id}")
    @ResponseBody
    public String getTaskList(@PathVariable("probe_id") Integer probeId, Model model, HttpSession session)
            throws Exception {
        scheduledProbeTaskService.pullTasks();
        return "task";
    }
    //
    //    // 查询全部部门
    //    @GetMapping("/detail/{id}")
    //    public TaskPo getDepartment(@PathVariable("id") String id){
    //        return taskMapper.getTask(id);
    //    }

}
