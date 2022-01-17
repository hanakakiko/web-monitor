package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.TaskMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.service.ScheduledProbeTaskService;
import com.dingjiangying.webmonitor.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProbeController {

    @Autowired
    private ScheduledProbeTaskService scheduledProbeTaskService;

    @Autowired
    CommonController commonController;

    @GetMapping("/pulltask/{probe_id}")
    @ResponseBody
    public String getTaskList(@PathVariable("probe_id") Integer probeId, Model model, HttpSession session) {
        scheduledProbeTaskService.pullTasks(probeId);
        return "task";
    }
    //
    //    // 查询全部部门
    //    @GetMapping("/detail/{id}")
    //    public TaskPo getDepartment(@PathVariable("id") String id){
    //        return taskMapper.getTask(id);
    //    }

}
