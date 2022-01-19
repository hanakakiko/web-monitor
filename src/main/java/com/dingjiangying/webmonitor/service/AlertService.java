package com.dingjiangying.webmonitor.service;

import com.alibaba.fastjson.JSON;
import com.dingjiangying.webmonitor.dao.AlertRulePoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlertService {
    @Resource
    AlertRulePoMapper alertRulePoMapper;

    @Resource
    TaskPoMapper taskPoMapper;

    public void updateAlertTaskCounts() {
//        粗暴查全表 防止增删count不一致
        TaskPoExample taskPoExample = new TaskPoExample();
        List<TaskPo> taskPos = taskPoMapper.selectByExample(taskPoExample);

        //统计key=alertId的taskCount
        Map<Integer, Integer> alertRuleCountMap = new HashMap();
        for (int i = 0; i < taskPos.size(); i++) {
            TaskPo taskPo = taskPos.get(i);
            if (taskPo.getAlertId() != null) {
                List<Integer> alertIds = JSON.parseObject(taskPo.getAlertId(), List.class);

                for (int j = 0; j < alertIds.size(); j++) {
                    alertRuleCountMap.putIfAbsent(alertIds.get(j), 0);
                    alertRuleCountMap.put(alertIds.get(j), alertRuleCountMap.get(alertIds.get(j)) + 1);
                }
            }
        }


        AlertRulePoExample alertRulePoExample = new AlertRulePoExample();
        List<AlertRulePo> alertRulePos = alertRulePoMapper.selectByExample(alertRulePoExample);


        for (int i = 0; i < alertRulePos.size(); i++) {
            AlertRulePo alertRulePo = alertRulePos.get(i);
            if(alertRuleCountMap.containsKey(alertRulePo.getAlertId())){
                alertRulePo.setTaskCount(alertRuleCountMap.get(alertRulePo.getAlertId()));
            }
            alertRulePoMapper.updateByPrimaryKeySelective(alertRulePo);
        }
    }

}
