package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.po.AlertRulePo;
import com.dingjiangying.webmonitor.po.AlertRulePoExample;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.ProbePoExample;
import com.dingjiangying.webmonitor.service.ScheduledProbeTaskService;
import com.dingjiangying.webmonitor.util.Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ScheduledProbeTaskService scheduledProbeTaskService;

    @Autowired
    CommonController commonController;

    @Autowired
    ProbePoMapper probePoMapper;

    @RequestMapping("/list")
    public String getProbeList(Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
//        Integer currentUserId = Util.getCurrentUserId(session);
        //获取所有探针
        List<ProbePo> probePos = probePoMapper.selectByExample(new ProbePoExample());

        model.addAttribute("probes", probePos);
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        //        commonController.putUserName(model);
        return "probe";
    }

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
