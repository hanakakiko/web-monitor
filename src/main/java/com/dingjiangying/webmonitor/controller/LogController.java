package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.*;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.LogVo;
import com.dingjiangying.webmonitor.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            vo.setAvailability(po.getAvailability());
            vo.setTotalNum(po.getTotalNum());

            logVos.add(vo);
        }
        model.addAttribute("logs", logVos);
//        System.out.println(taskId);
        return "log";
    }

}
