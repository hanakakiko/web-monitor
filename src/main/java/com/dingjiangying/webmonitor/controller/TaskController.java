package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.TaskMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.ProbePoExample;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.po.TaskPoExample;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskPoMapper taskMapper;

    @Autowired
    private ProbePoMapper probeMapper;

    @Autowired
    CommonController commonController;

    @RequestMapping("/list")
    public String getTaskList(Model model, HttpSession session) {
        Integer currentUserId = Util.getCurrentUserId(session);


        //获取探针列表
        ProbePoExample probePoExample = new ProbePoExample();
//        probePoExample.createCriteria().andUserIdEqualTo(currentUserId);
        List<ProbePo> probePos = probeMapper.selectByExample(probePoExample);

        Map<Integer, String> probNameMap = new HashMap<>();
        for (int i = 0; i < probePos.size(); i++) {
            probNameMap.put(probePos.get(i).getProbeId(), probePos.get(i).getProbeName());
        }
        //todo 根据管理员
        if (currentUserId != null) {
            TaskPoExample taskPoExample = new TaskPoExample();
            taskPoExample.createCriteria().andUserIdEqualTo(currentUserId);

            List<TaskPo> taskPos = taskMapper.selectByExample(taskPoExample);

            List<TaskVo> taskVos = new ArrayList<>();
            for (int i = 0; i < taskPos.size(); i++) {
                TaskPo po = taskPos.get(i);
                TaskVo vo = new TaskVo();
                vo.setTaskName(po.getTaskName());
                vo.setTaskUrl(po.getTaskUrl());
                vo.setTaskId(po.getTaskId());
                vo.setHasHuddled(po.getHasHuddled());
//                Util.getCurrentTime()
                if (po.getCreateTime() != null) {
                    vo.setCreateTime(Util.dateToString(po.getCreateTime()));
                }

                List<String> cityList = Util.getList(po.getCityList());
                String probNames = "";
                for (int j = 0; j < cityList.size(); j++) {
                    String probName = probNameMap.get(new Integer(cityList.get(j)));
                    if (j != 0) {
                        probNames += ",";
                    }
                    probNames += probName;
                }
                vo.setProbeListNames(probNames);
                taskVos.add(vo);
            }
//        List<TaskPo> tasks = taskMapper.getTasks();
            model.addAttribute("tasks", taskVos);
        }


        model.addAttribute("probs", probePos);
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
//        commonController.putUserName(model);
        return "task";
    }


    @RequestMapping("/add_task_form")
    public String addTask(Model model, HttpSession session, @ModelAttribute(value = "taskinfo") TaskVo taskinfo) {
        Integer currentUserId = Util.getCurrentUserId(session);

        TaskPo taskPo = new TaskPo();

        if (taskinfo.getProbeList() != null) {
            String cityList = Util.getFromList(taskinfo.getProbeList());
            taskPo.setCityList(cityList);
        }

        taskPo.setTaskName(taskinfo.getTaskName());
        taskPo.setTaskUrl(taskinfo.getTaskUrl());
        //todo
//        taskPo.setScriptPath();

        taskPo.setUserId(currentUserId);
        taskPo.setCreateTime(new Date());
        taskPo.setHasHuddled(0);
//        taskinfo.setCreateTime(Util.getCurrentTime());
        taskMapper.insert(taskPo);
//        System.out.println(taskinfo);
        return "redirect:/task/list";
    }

//
//    // 查询全部部门
//    @GetMapping("/detail/{id}")
//    public TaskPo getDepartment(@PathVariable("id") String id){
//        return taskMapper.getTask(id);
//    }

}
