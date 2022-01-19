package com.dingjiangying.webmonitor.controller;

import com.alibaba.fastjson.JSON;
import com.dingjiangying.webmonitor.dao.AlertRulePoMapper;
import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.*;
import com.dingjiangying.webmonitor.service.AlertService;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.AlertRuleVo;
import com.dingjiangying.webmonitor.vo.ProbeVo;
import com.dingjiangying.webmonitor.vo.TaskVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @Autowired
    AlertService alertService;


    @Autowired
    private AlertRulePoMapper alertRulePoMapper;

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

        //获取alert的id和name的映射
        Map<Integer, String> alertNameMap = new HashMap<>();
        AlertRulePoExample alertRulePoExample1 = new AlertRulePoExample();
        alertRulePoExample1.createCriteria().andUserIdEqualTo(currentUserId);
        List<AlertRulePo> alertRulePos = alertRulePoMapper.selectByExample(alertRulePoExample1);
        for (int i = 0; i < alertRulePos.size(); i++) {
            alertNameMap.put(alertRulePos.get(i).getAlertId(), alertRulePos.get(i).getAlertName());
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
                BeanUtils.copyProperties(po, vo);
//                Util.getCurrentTime()
                if (po.getCreateTime() != null) {
                    vo.setCreateTime(Util.dateToString(po.getCreateTime()));
                }

//                List<String> cityList = Util.getList(po.getCityList());
                List<Integer> cityList = JSON.parseObject(po.getCityList(), List.class);
                String probNames = "";
                if (!CollectionUtils.isEmpty(cityList)) {
                    for (int j = 0; j < cityList.size(); j++) {
                        String probName = probNameMap.get(new Integer(cityList.get(j)));
                        if (j != 0) {
                            probNames += ",";
                        }
                        probNames += probName;
                    }
                }
                vo.setProbeListNames(probNames);

                List<Integer> alertList = JSON.parseObject(po.getAlertId(), List.class);
                String alertNames = "";
                if (!CollectionUtils.isEmpty(alertList)) {
                    for (int j = 0; j < alertList.size(); j++) {
                        String alertName = alertNameMap.get(new Integer(alertList.get(j)));
                        if (j != 0) {
                            alertNames += ",";
                        }
                        alertNames += alertName;
                    }
                }
                vo.setAlertListNames(alertNames);

                taskVos.add(vo);
            }
//        List<TaskPo> tasks = taskMapper.getTasks();
            model.addAttribute("tasks", taskVos);
        }


//        model.addAttribute("probs", probePos);
//        AlertRulePoExample alertRulePoExample=new AlertRulePoExample();
//        alertRulePoExample.createCriteria().andUserIdEqualTo(currentUserId);
//        List<AlertRulePo> alertRulePos = alertRulePoMapper.selectByExample(alertRulePoExample);

        model.addAttribute("alert_rules",alertRulePos);
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
//        commonController.putUserName(model);
        return "task";
    }


    @RequestMapping("/add_task_form")
    public String addTask(Model model, HttpSession session, @ModelAttribute(value = "taskinfo") TaskVo taskinfo) {
        Integer currentUserId = Util.getCurrentUserId(session);

        TaskPo taskPo = new TaskPo();

        if (taskinfo.getProbeList() != null) {

//            String cityList = Util.getFromList(taskinfo.getProbeList());
            taskPo.setCityList(JSON.toJSONString(taskinfo.getProbeList()));
        }

        taskPo.setTaskName(taskinfo.getTaskName());
        taskPo.setTaskUrl(taskinfo.getTaskUrl());
        //todo
//        taskPo.setScriptPath();
        if (taskinfo.getAlertRuleList() != null) {
            taskPo.setAlertId(JSON.toJSONString(taskinfo.getAlertRuleList()));
        }
        taskPo.setUserId(currentUserId);
        taskPo.setCreateTime(new Date());
        taskPo.setUmpdateTime(new Date());
        taskPo.setHasHuddled(0);
//        taskinfo.setCreateTime(Util.getCurrentTime());
        taskMapper.insert(taskPo);

        alertService.updateAlertTaskCounts();
//        System.out.println(taskinfo);
        return "redirect:/task/list";
    }


    @RequestMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable Integer taskId, Model model, HttpSession session) {
//        System.out.println(taskId);
        taskMapper.deleteByPrimaryKey(taskId);
        alertService.updateAlertTaskCounts();
        return "redirect:/task/list";
    }


    @RequestMapping("/edit/{taskId}")
    public String getEditTask(@PathVariable Integer taskId, Model model, HttpSession session, @ModelAttribute(value = "taskinfo") TaskVo taskinfo) {
//        获取task信息
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
//        taskMapper.deleteByPrimaryKey(taskId);
//        return "redirect:/task/list";


        TaskPo taskPo = taskMapper.selectByPrimaryKey(taskId);
        TaskVo vo = new TaskVo();
        vo.setTaskName(taskPo.getTaskName());
        vo.setTaskUrl(taskPo.getTaskUrl());
        vo.setTaskId(taskPo.getTaskId());
        vo.setHasHuddled(taskPo.getHasHuddled());
//                Util.getCurrentTime()
        if (taskPo.getCreateTime() != null) {
            vo.setCreateTime(Util.dateToString(taskPo.getCreateTime()));
        }

//        获取该task选中的探针
        Set<Integer> probIdSet = null;
        if (taskPo.getCityList() != null) {
            List<Integer> probIds = JSON.parseObject(taskPo.getCityList(), List.class);
            probIdSet = new HashSet<>(probIds);
        }

        //获取探针列表
        ProbePoExample probePoExample = new ProbePoExample();
        List<ProbePo> probePos = probeMapper.selectByExample(probePoExample);
        List<ProbeVo> probeVos = new ArrayList<>();
        for (int i = 0; i < probePos.size(); i++) {
            ProbeVo probeVo = new ProbeVo();
            ProbePo probePo = probePos.get(i);
            BeanUtils.copyProperties(probePo, probeVo);
            probeVos.add(probeVo);
            if (probIdSet != null) {
                if (probIdSet.contains(probePo.getProbeId())) {
//                    包含则选中
                    probeVo.setChecked(1);
                }
            }
        }

        List<AlertRuleVo> alertRuleVos=new ArrayList<>();

        model.addAttribute("probs", probeVos);

        model.addAttribute("task", vo);
        return "/task_edit";
    }


    @RequestMapping("/edit_form")
    public String editTask(Model model, HttpSession session, @ModelAttribute(value = "taskinfo") TaskVo taskinfo) {
//        获取task信息
        Integer currentUserId = Util.getCurrentUserId(session);
//        System.out.println(taskinfo);
        TaskPo taskPo = new TaskPo();

        if (taskinfo.getProbeList() != null) {
            taskPo.setCityList(JSON.toJSONString(taskinfo.getProbeList()));
        }
        taskPo.setTaskId(taskinfo.getTaskId());
        taskPo.setTaskName(taskinfo.getTaskName());
        taskPo.setTaskUrl(taskinfo.getTaskUrl());
        //todo
//        taskPo.setScriptPath();

        taskPo.setUserId(currentUserId);
        taskPo.setUmpdateTime(new Date());
        taskPo.setHasHuddled(0);
//        taskinfo.setCreateTime(Util.getCurrentTime());
        taskMapper.updateByPrimaryKeySelective(taskPo);
        return "redirect:/task/list";
    }


//
//    // 查询全部部门
//    @GetMapping("/detail/{id}")
//    public TaskPo getDepartment(@PathVariable("id") String id){
//        return taskMapper.getTask(id);
//    }

}
