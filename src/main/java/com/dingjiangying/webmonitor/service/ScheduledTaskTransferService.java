package com.dingjiangying.webmonitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.LogPo;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.po.TaskPoExample;
import com.sun.tracing.Probe;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

@Component
@EnableScheduling
public class ScheduledTaskTransferService {

    @Autowired
    ProbePoMapper probePoMapper;

    @Autowired
    TaskPoMapper taskPoMapper;

    @Scheduled(fixedRate = 60000)//一分钟分配一次
    @Async
    public void transferTasks() throws Exception {
        List<TaskPo> newTask = getNewTask();
        Map<Integer,List<Integer>> map = new HashMap<>();
        //分配给各个探针
        for(TaskPo taskPo : newTask){
            Integer taskId = taskPo.getTaskId();
            List<Integer> probeList = JSON.parseArray(taskPo.getCityList(),Integer.class);
            if(!CollectionUtils.isEmpty(probeList)){
                for(Integer probeId : probeList){
                    if(!map.containsKey(probeId)){
                        map.put(probeId,new ArrayList<>());
                    }
                    List<Integer> taskIds = map.get(probeId);
                    taskIds.add(taskId);
                }
            }
        }
        //更新到探针active_task_list
        for(Map.Entry entry : map.entrySet()){
            List<Integer> oldActiveTaskList =
                    JSON.parseArray(probePoMapper.selectByPrimaryKey((Integer) entry.getKey()).getActiveTaskList(),
                            Integer.class);
            if(oldActiveTaskList==null){
                oldActiveTaskList = new ArrayList<>();
            }
            List<Integer> activeTaskList = (List<Integer>) entry.getValue();
            //取交集，因为可能上一批的任务探针还没拉完,不能覆盖
            activeTaskList.removeAll(oldActiveTaskList);
            activeTaskList.addAll(oldActiveTaskList);
            //更新
            ProbePo probePo = new ProbePo();
            probePo.setProbeId((Integer) entry.getKey());
            probePo.setActiveTaskList(JSON.toJSONString(activeTaskList));
            probePoMapper.updateByPrimaryKeySelective(probePo);
        }
        //把任务状态置为handled
        for(TaskPo taskPo : newTask){
            TaskPo taskPo1 = new TaskPo();
            taskPo1.setTaskId(taskPo.getTaskId());
            taskPo1.setHasHuddled(1);
            taskPoMapper.updateByPrimaryKeySelective(taskPo1);
        }
    }

    public List<TaskPo> getNewTask(){
        TaskPoExample taskPoExample = new TaskPoExample();
        TaskPoExample.Criteria criteria = taskPoExample.createCriteria();
        criteria.andHasHuddledEqualTo(0);
        List<TaskPo> taskPos = taskPoMapper.selectByExample(taskPoExample);
        if(taskPos==null){
            return new ArrayList<>();
        }
        return taskPos;
    }

}
