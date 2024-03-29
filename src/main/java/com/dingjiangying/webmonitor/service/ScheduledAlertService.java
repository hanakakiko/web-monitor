package com.dingjiangying.webmonitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingjiangying.webmonitor.consts.AlertTypeConsts;
import com.dingjiangying.webmonitor.dao.AlertRulePoMapper;
import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.AlertRulePo;
import com.dingjiangying.webmonitor.po.AlertRulePoExample;
import com.dingjiangying.webmonitor.po.LogPo;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.LogPo;
import com.dingjiangying.webmonitor.po.LogPoExample;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.vo.ContactVo;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.Har;
import de.sstoehr.harreader.model.HarEntry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import static java.lang.Thread.sleep;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
@EnableScheduling
public class ScheduledAlertService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    UserPoMapper userPoMapper;

    @Autowired
    ProbePoMapper probePoMapper;

    @Autowired
    LogPoMapper logPoMapper;

    @Autowired
    TaskPoMapper taskPoMapper;

    @Autowired
    AlertRulePoMapper alertRulePoMapper;

    public static final String LOCALTASKPATH = "./localLogs.txt";

    public static final String LOCALLOGPATH = "./locallogs";

    public static final Integer MAXCONCURRENT = 3;

    public static final String REMOTEPATH = "root@101.200.161.136";

    public static final String REMOTEPASSWORD = "Dd1woshishei?jiangy";

    public static Integer PROBEID = null;

    @Scheduled(fixedRate = 5000)//一秒钟检测一次
    @Async
    public void checkLogAndAlert() throws Exception {
        List<LogPo> newLog = getNewLog();
        for (LogPo logPo : newLog) {
            Integer taskId = logPo.getTaskId();
            TaskPo taskPo = taskPoMapper.selectByPrimaryKey(taskId);

            if (taskPo == null) {
                logPoMapper.deleteByPrimaryKey(logPo.getLogId());
//                未找到
                continue;
            }
            String taskName = taskPo.getTaskName();
            //todo alertId 是字符串 还可能有多个
            if (!StringUtils.isEmpty(taskPo.getAlertId())) {
                continue;
            }
            List<Integer> alertIds = JSON.parseArray(taskPo.getAlertId(), Integer.class);
            if (!CollectionUtils.isEmpty(alertIds)) {
                //查出所有告警规则
                AlertRulePoExample alertRulePoExample = new AlertRulePoExample();
                alertRulePoExample.createCriteria().andAlertIdIn(alertIds);
                List<AlertRulePo> alertRulePos = alertRulePoMapper.selectByExample(alertRulePoExample);
                String probeName = probePoMapper.selectByPrimaryKey(logPo.getProbeId()).getProbeName();
                boolean shouldAlert = false;
                List<String> messages = new ArrayList<>();
                for (AlertRulePo alertRulePo : alertRulePos) {
                    switch (alertRulePo.getAlertType()) {
                        case AlertTypeConsts.TIMEOUT:
                            Integer time = Integer.parseInt(alertRulePo.getAlertParam());
                            if (logPo.getTotalTime() > time) {
                                shouldAlert = true;
                                String message =
                                        "您的任务：[" + taskName + "] 在探针：[" + probeName + "] 触发：[" + alertRulePo.getAlertName() + "] "
                                                + "告警规则，告警详情：任务执行用时" + logPo.getTotalTime() + "ms大于阈值" + time + "ms";
                                messages.add(message);
                            }
                            break;
                        case AlertTypeConsts.UNAVAILABLE:
                            Double availability = Double.valueOf(alertRulePo.getAlertParam());
                            if (logPo.getAvailability() * 100 < availability) {
                                shouldAlert = true;
                                String message =
                                        "您的任务：[" + taskName + "] 在探针：[" + probeName + "] 触发：[" + alertRulePo.getAlertName() + "] "
                                                + "告警规则，告警详情：任务资源可用率" + logPo.getAvailability() * 100 + "%小于阈值" + availability + "%";
                                messages.add(message);
                            }
                            break;
                        default:
                    }
                }

                LogPo logPo1 = new LogPo();
                logPo1.setLogId(logPo.getLogId());

                if (shouldAlert) {
                    logPo1.setErrorCode(1);
                    Integer userId = taskPo.getUserId();
                    ContactVo contactVo =
                            JSON.parseObject(userPoMapper.selectByPrimaryKey(userId).getContact(), ContactVo.class);
                    sendAlertMail(taskName, messages, contactVo.getMail());
                } else {
                    logPo1.setErrorCode(0);
                }

                //最后修改log状态位
                logPo1.setHasHandled(1);
                logPoMapper.updateByPrimaryKeySelective(logPo1);
                //其实还要修改task和user记录里的现存告警次数
            }
        }
    }

    public void sendAlertMail(String taskName, List<String> messages, String mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("【告警】" + taskName + " 触发告警");
        simpleMailMessage.setText(String.valueOf(messages));
        simpleMailMessage.setFrom("1104349906@qq.com");
        simpleMailMessage.setTo(mail);
        javaMailSender.send(simpleMailMessage);
    }

    public List<LogPo> getNewLog() {
        LogPoExample logPoExample = new LogPoExample();
        LogPoExample.Criteria criteria = logPoExample.createCriteria();
        criteria.andHasHandledEqualTo(0);
        List<LogPo> logPos = logPoMapper.selectByExample(logPoExample);
        if (logPos == null) {
            return new ArrayList<>();
        }
        return logPos;
    }

}
