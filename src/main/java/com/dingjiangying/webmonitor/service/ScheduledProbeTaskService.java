package com.dingjiangying.webmonitor.service;

import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.util.Util;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
@EnableScheduling
public class ScheduledProbeTaskService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

//    @Scheduled(fixedRate = 20000)//20s一次
    public void sendmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("邮件发送测试");
        simpleMailMessage.setText("测试下");
        simpleMailMessage.setFrom("1104349906@qq.com");
        simpleMailMessage.setTo("2000022759@stu.pku.edu.cn");
        javaMailSender.send(simpleMailMessage);
    }

    @Autowired
    ProbePoMapper probePoMapper;

    @Autowired
    TaskPoMapper taskPoMapper;

    @Scheduled(fixedRate = 60000)//一分钟拉一次
    public void pullTasks(Integer probeId) {
        String activeTaskList = probePoMapper.selectByPrimaryKey(probeId).getActiveTaskList();
        List<String> activeTaskIdList = Util.getList(activeTaskList);
        List<Integer> users2 = JSON.parseArray(activeTaskList, Integer.class);
        List<String> taskIdList = new ArrayList<>();
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setSubject("邮件发送测试");
//        simpleMailMessage.setText("测试下");
//        simpleMailMessage.setFrom("1104349906@qq.com");
//        simpleMailMessage.setTo("2000022759@stu.pku.edu.cn");
//        javaMailSender.send(simpleMailMessage);
        String localTaskPath = "./localTasks.txt";
        File localTasks = new File(localTaskPath);
        try {
            // 检查目标文件是否存在，不存在则创建
            if (!localTasks.exists()) {
                localTasks.createNewFile();// 创建目标文件
            }
            //所有taskPo的json列表
            List<String> localTaskStringList = getFileContext(localTaskPath);

            //只留下update里没有的task
            List<TaskPo> localTaskList = localTaskStringList.stream()
                    .map(taskString -> JSONObject.parseObject(taskString, TaskPo.class))
                    .filter(task -> !activeTaskIdList.contains(String.valueOf(task.getTaskId())))
                    .collect(Collectors.toList());

            //这里最好在mapper写个按id列表查询
            for (String activeId : activeTaskIdList) {
                TaskPo taskPo = taskPoMapper.selectByPrimaryKey(Integer.parseInt(activeId));
                localTaskList.add(taskPo);
            }

            //更新probeTask列表
            List<>

            //写回文件
            localTaskStringList = localTaskList.stream().map(JSONObject::toJSONString).collect(Collectors.toList());
            writeFileContext(localTaskStringList, localTaskPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //从文件按行读入列表
    public static List<String> getFileContext(String path) throws Exception {
        FileReader fileReader =new FileReader(path);
        BufferedReader bufferedReader =new BufferedReader(fileReader);
        List<String> list =new ArrayList<>();
        String str=null;
        while((str=bufferedReader.readLine())!=null) {
            if(str.trim().length()>2) {
                list.add(str);
            }
        }
        return list;
    }

    //将列表按行写入文件
    public static void writeFileContext(List<String>  strings, String path) throws Exception {
        File file = new File(path);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        if(System.getProperty("os.name").equals("Windows")){
            for (String l:strings){
                writer.write(l + "\r\n");
            }
        }else{
            for (String l:strings){
                writer.write(l + "\n");
            }
        }

        writer.close();
    }

    public void createFile() throws IOException {
        String filePath = "D:/a/b";
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();// mkdirs创建多级目录
        }
        File checkFile = new File(filePath + "/filename.txt");
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile();// 创建目标文件
            }
            // 三、向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(checkFile, true);
            writer.append("your content");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }

}
