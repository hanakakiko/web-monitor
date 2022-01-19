package com.dingjiangying.webmonitor.controller;

import com.alibaba.fastjson.JSON;
import com.dingjiangying.webmonitor.dao.AlertRulePoMapper;
import com.dingjiangying.webmonitor.po.AlertRulePo;
import com.dingjiangying.webmonitor.po.AlertRulePoExample;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.ProbePoExample;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.po.TaskPoExample;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.ProbeVo;
import com.dingjiangying.webmonitor.vo.TaskVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    CommonController commonController;

    @Autowired
    AlertRulePoMapper alertRulePoMapper;

    @RequestMapping("/list")
    public String getAlertList(Model model, HttpSession session) {
        Integer currentUserId = Util.getCurrentUserId(session);

        //获取用户的告警规则（告警规则表加user_id字段！）

        List<AlertRulePo> alertRulePos = alertRulePoMapper.selectByExample(new AlertRulePoExample());
        model.addAttribute("alerts",alertRulePos);
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        //        commonController.putUserName(model);
        return "alert";
    }

    /**
     * 新建告警规则(还没做非法输入校验（尤其是alertParam）)
     * @param model
     * @param session
     * @param alertRulePo
     * @return
     */
    @RequestMapping("/add_alert_form")
    public String addAlertRule(Model model, HttpSession session,
            @ModelAttribute(value = "alert") AlertRulePo alertRulePo) {
        Integer currentUserId = Util.getCurrentUserId(session);

        alertRulePo.setTaskCount(0);
//        alertRulePo.setUserId(currentUserId);

        alertRulePoMapper.insert(alertRulePo);
        //        System.out.println(taskinfo);
        return "redirect:/alert/list";
    }

    @RequestMapping("/delete/{alertId}")
    public String deleteAlert(@PathVariable Integer alertId, Model model, HttpSession session) {
        //        System.out.println(taskId);

//        taskMapper.deleteByPrimaryKey(taskId);
        return "redirect:/task/list";
    }


    @RequestMapping("/edit/{taskId}")
    public String getEditTask(@PathVariable Integer taskId, Model model, HttpSession session, @ModelAttribute(value = "taskinfo") TaskVo taskinfo) {
        //        获取task信息
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        //        taskMapper.deleteByPrimaryKey(taskId);
        //        return "redirect:/task/list";


//        TaskPo taskPo = taskMapper.selectByPrimaryKey(taskId);
//        TaskVo vo = new TaskVo();
//        vo.setTaskName(taskPo.getTaskName());
//        vo.setTaskUrl(taskPo.getTaskUrl());
//        vo.setTaskId(taskPo.getTaskId());
//        vo.setHasHuddled(taskPo.getHasHuddled());
//        //                Util.getCurrentTime()
//        if (taskPo.getCreateTime() != null) {
//            vo.setCreateTime(Util.dateToString(taskPo.getCreateTime()));
//        }
//
//        //        获取该task选中的探针
//        Set<Integer> probIdSet = null;
//        if (taskPo.getCityList() != null) {
//            List<Integer> probIds = JSON.parseObject(taskPo.getCityList(), List.class);
//            probIdSet = new HashSet<>(probIds);
//        }
//
//        //获取探针列表
//        ProbePoExample probePoExample = new ProbePoExample();
//        List<ProbePo> probePos = probeMapper.selectByExample(probePoExample);
//        List<ProbeVo> probeVos = new ArrayList<>();
//        for (int i = 0; i < probePos.size(); i++) {
//            ProbeVo probeVo = new ProbeVo();
//            ProbePo probePo = probePos.get(i);
//            BeanUtils.copyProperties(probePo, probeVo);
//            probeVos.add(probeVo);
//            if (probIdSet != null) {
//                if (probIdSet.contains(probePo.getProbeId())) {
//                    //                    包含则选中
//                    probeVo.setChecked(1);
//                }
//            }
//        }
//
//        model.addAttribute("probs", probeVos);
//
//        model.addAttribute("task", vo);
        return "/task_edit";
    }

}
