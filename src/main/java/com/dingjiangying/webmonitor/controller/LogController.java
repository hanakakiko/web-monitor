package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.*;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.LogVo;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private TaskPoMapper taskMapper;

    @Autowired
    private LogPoMapper logMapper;

    @Autowired
    private UserPoMapper userPoMapper;

    @RequestMapping("/task/{taskId}")
    public String listByTask(@PathVariable Integer taskId, Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));

        LogPoExample example = new LogPoExample();
        example.createCriteria().andTaskIdEqualTo(taskId);

        List<LogPo> logPos = logMapper.selectByExample(example);
        List<LogVo> logVos = new ArrayList<>();
        for (int i = 0; i < logPos.size(); i++) {
            LogVo vo = new LogVo();
            LogPo po = logPos.get(i);
            vo.setLogId(po.getLogId());
            vo.setTaskId(po.getTaskId());
            vo.setProbeId(po.getProbeId());
            vo.setTimestamp(Util.dateToString(po.getTimestamp()));
            vo.setHasHandled(po.getHasHandled());
            vo.setTotalNum(po.getTotalNum());
            vo.setErrorCode(po.getErrorCode());
            vo.setScriptOutputPath(po.getScriptOutputPath());
            vo.setAvailability(String.format("%.2f", po.getAvailability() * 100)+"%");
            vo.setTotalTime(String.valueOf(po.getTotalTime())+"ms");

            logVos.add(vo);
        }
        model.addAttribute("logs", logVos);
//        System.out.println(taskId);
        return "log";
    }

    @RequestMapping("/probe/{probeId}")
    public String listByProbe(@PathVariable Integer probeId, Model model, HttpSession session) {

        String userName = Util.getCurrentUserName(session);
        model.addAttribute("currentUser", userName);

        //并且是本用户的任务
        UserPoExample userPoExample = new UserPoExample();
        userPoExample.createCriteria().andUserNameEqualTo(userName);
        //正常session取得名字不会查不到
        Integer userId =
                userPoMapper.selectByExample(userPoExample).get(0).getUserId();

        //查任务id
        TaskPoExample taskPoExample = new TaskPoExample();
        taskPoExample.createCriteria().andUserIdEqualTo(userId);
        List<Integer> taskIds =
                taskMapper.selectByExample(taskPoExample).stream().map(TaskPo::getTaskId).collect(
                        Collectors.toList());

        //查任务id和probeid都符合的
        LogPoExample example = new LogPoExample();
        example.createCriteria().andProbeIdEqualTo(probeId).andTaskIdIn(taskIds);
        List<LogPo> logPos = logMapper.selectByExample(example);
        List<LogVo> logVos = new ArrayList<>();
        for (int i = 0; i < logPos.size(); i++) {
            LogVo vo = new LogVo();
            LogPo po = logPos.get(i);
            vo.setLogId(po.getLogId());
            vo.setTaskId(po.getTaskId());
            vo.setProbeId(po.getProbeId());
            vo.setTimestamp(Util.dateToString(po.getTimestamp()));
            vo.setHasHandled(po.getHasHandled());
            vo.setTotalNum(po.getTotalNum());
            vo.setErrorCode(po.getErrorCode());
            vo.setScriptOutputPath(po.getScriptOutputPath());
            vo.setAvailability(String.format("%.2f", po.getAvailability() * 100)+"%");
            vo.setTotalTime(String.valueOf(po.getTotalTime())+"ms");

            logVos.add(vo);
        }
        model.addAttribute("logs", logVos);
        //        System.out.println(taskId);
        return "log";
    }

}
