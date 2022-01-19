package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.LogPo;
import com.dingjiangying.webmonitor.po.LogPoExample;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.po.TaskPoExample;
import com.dingjiangying.webmonitor.po.UserPo;
import com.dingjiangying.webmonitor.po.UserPoExample;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.SummaryVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    CommonController commonController;

    @Autowired
    UserPoMapper userPoMapper;

    @Autowired
    LogPoMapper logPoMapper;

    @Autowired
    TaskPoMapper taskPoMapper;

    @RequestMapping("/summury")
    public String getGreenPage(Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));

        //找userId
        UserPoExample userPoExample = new UserPoExample();
        UserPoExample.Criteria userPoExampleCriteria = userPoExample.createCriteria();
        userPoExampleCriteria.andUserNameEqualTo(Util.getCurrentUserName(session));
        List<UserPo> users = userPoMapper.selectByExample(userPoExample);
        UserPo userPo = users.get(0);

        //找user的全部任务
        TaskPoExample taskPoExample = new TaskPoExample();
        TaskPoExample.Criteria taskPoExampleCriteria = taskPoExample.createCriteria();
        taskPoExampleCriteria.andUserIdEqualTo(userPo.getUserId());
        List<TaskPo> taskPos = taskPoMapper.selectByExample(taskPoExample);
        List<Integer> taskIds = taskPos.stream().map(TaskPo::getTaskId).collect(Collectors.toList());

        SummaryVo summaryVo = new SummaryVo();


        List<Long> logTimeCosts=new ArrayList<>();
        List<Double> logAvailability=new ArrayList<>();
        List<String> logDates=new ArrayList<>();
        if(!CollectionUtils.isEmpty(taskIds)){
            //找这些任务的全部日志
            LogPoExample logPoExample = new LogPoExample();
            LogPoExample.Criteria logPoExampleCriteria = logPoExample.createCriteria();
            logPoExampleCriteria.andTaskIdIn(taskIds);
            logPoExample.setOrderByClause("timestamp ASC");
            List<LogPo> logPos = logPoMapper.selectByExample(logPoExample);
            if(!CollectionUtils.isEmpty(logPos)){
                int averageTotalTime = (int) logPos.stream().mapToLong(LogPo::getTotalTime).average().getAsDouble();

                double averageAvalibility = logPos.stream().mapToDouble(LogPo::getAvailability).average().getAsDouble();

                summaryVo.setAverageTime(String.valueOf(averageTotalTime)+"ms");
                summaryVo.setAverageAvailability(String.format("%.2f", averageAvalibility * 100)+"%");

                logDates = logPos.stream().map(x -> {
                    SimpleDateFormat sformat = new SimpleDateFormat("MM-dd hh:mm");//日期格式
                    String tiem = "'" + sformat.format(x.getTimestamp()) + "'";
                    return tiem;
                }).collect(Collectors.toList());

                logTimeCosts = logPos.stream().map(LogPo::getTotalTime).collect(Collectors.toList());

                logAvailability=logPos.stream().map(LogPo::getAvailability).collect(Collectors.toList());

            }

        }

        model.addAttribute("logDates", logDates);
        model.addAttribute("logTimeCosts", logTimeCosts);
        model.addAttribute("logAvailability", logAvailability);

        model.addAttribute("summary", summaryVo);

        return "monitor";
    }

}
