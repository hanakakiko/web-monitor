package com.dingjiangying.webmonitor.service;

import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.ProbePoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.po.LogPo;
import com.dingjiangying.webmonitor.po.ProbePo;
import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.util.DockerClientUtils;
import com.dingjiangying.webmonitor.util.Util;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.jackson.DefaultMapperFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Thread.sleep;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.apache.logging.log4j.util.Strings;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import de.sstoehr.harreader.model.*;

import java.text.SimpleDateFormat;

@Component
@EnableScheduling
public class ScheduledProbeTaskService {

    @Autowired
    ProbePoMapper probePoMapper;

    @Autowired
    TaskPoMapper taskPoMapper;

    @Autowired
    LogPoMapper logPoMapper;

    public static final String LOCALTASKPATH = "./localTasks.txt";

    public static final String LOCALLOGPATH = "./locallogs";

    public static final Integer MAXCONCURRENT = 3;

    public static final String REMOTEPATH = "root@101.200.161.136";

    public static final String REMOTEPASSWORD = "Dd1woshishei?jiangy";

    public static Integer PROBEID = null;

    public static Integer TIMEOUT = 20000;

    @Scheduled(fixedRate = 60000)//??????????????????
    @Async
    public void pullTasks() throws Exception {
        if (PROBEID == null) {
            return;
        }
        String activeTaskList = probePoMapper.selectByPrimaryKey(PROBEID).getActiveTaskList();

//        activeTaskList = "[1,3,6,2]";
        File localTasks = new File(LOCALTASKPATH);
        if (!localTasks.exists()) {
            localTasks.createNewFile();// ??????????????????
        }
        //??????taskPo???json??????
        List<TaskPo> localTaskList = getFileContext(LOCALTASKPATH);
        //???????????????????????????
        if (Strings.isNotBlank(activeTaskList)) {
            //        activeTaskList = "[1,2,3,4]";
            List<Integer> activeTaskIdList = JSON.parseArray(activeTaskList, Integer.class);
            //        String localTaskPath = "./localTasks.txt";


            try {
                // ???????????????????????????????????????????????????


                //            update probe_po set task_list = '[1,2,3,4]', active_task_list = '[3,5]' where probe_id = '1'

                //?????????update????????????task
                localTaskList = localTaskList.stream()
                        .filter(task -> !activeTaskIdList.contains(task.getTaskId()))
                        .collect(Collectors.toList());

                //???????????????mapper?????????id????????????
                for (Integer activeId : activeTaskIdList) {
                    TaskPo taskPo = taskPoMapper.selectByPrimaryKey(activeId);
                    if (!Objects.isNull(taskPo)) {
                        localTaskList.add(taskPo);
                    }
                }

                //??????probe??????
                List<Integer> newProbetaskList =
                        localTaskList.stream().map(TaskPo::getTaskId).collect(Collectors.toList());

                String probeTaskList = JSON.toJSONString(newProbetaskList);

                ProbePo probePo = new ProbePo();
                probePo.setProbeId(PROBEID);
                probePo.setActiveTaskList("[]");
                probePo.setTaskList(probeTaskList);

                probePoMapper.updateByPrimaryKeySelective(probePo);

                //????????????
                writeFileContext(localTaskList, LOCALTASKPATH);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        runTasks(localTaskList);


        //            //?????????
        //            for(int i = 0; i < 3; i++){
        //                int size = localTaskList.size();
        //                int fromIndex = i * MAXCONCURRENT;
        //                int toIndex = (i+1) * MAXCONCURRENT;
        //                List<TaskPo> taskPoList = localTaskList.subList(fromIndex < size?fromIndex:size, toIndex>size?size:toIndex);
        //                runTasks(taskPoList);
        //
        //            }


    }

    //????????????limit???docker?????????MAXCONCURRENT?????????
    @Async
    public void runTasks(List<TaskPo> taskPoList) throws HarReaderException, InterruptedException {
        int size = taskPoList.size();
        if (size != 0) {
            int cycle = 60000 / size;
            for (TaskPo task : taskPoList) {
                runTask(task);
                sleep(cycle);
            }
        }
    }

    //??????????????????
    @Async
    public void runTask(TaskPo task) throws HarReaderException {
        File localLogs = new File(LOCALLOGPATH);
        // ???????????????????????????????????????????????????
        if (!localLogs.exists()) {
            localLogs.mkdir();// ??????????????????
        }

        String probePath = LOCALLOGPATH + "/" + String.valueOf(PROBEID);
        File probeDir = new File(probePath);
        // ???????????????????????????????????????????????????
        if (!probeDir.exists()) {
            probeDir.mkdir();// ??????????????????
        }

        String thisTaskPath = probePath + "/" + String.valueOf(task.getTaskId());
        File thisTaskDir = new File(thisTaskPath);

        if (!thisTaskDir.exists()) {
            thisTaskDir.mkdir();// ??????????????????
        }

        Long now = System.currentTimeMillis();

        String thisLogPath = thisTaskPath + "/" + now.toString();

        File thisLogDir = new File(thisLogPath);

        if (!thisLogDir.exists()) {
            thisLogDir.mkdir();// ??????????????????
        }


        //????????????
        String commandStr = "node puppeteer.js " + task.getTaskUrl() + " " + thisLogPath + " " + TIMEOUT;

        if (Strings.isNotBlank(task.getTaskUrl())) {
            exeCmd(commandStr);
            LogPo logPo = new LogPo();
            logPo.setHasHandled(0);
            logPo.setTaskId(task.getTaskId());
            logPo.setProbeId(PROBEID);
            logPo.setTimestamp(new Date(now));


            //????????????????????????
            commandStr = "sh " + "./pushLog.sh " + REMOTEPATH + " " + PROBEID + " " + String.valueOf(task.getTaskId()) + " " + now.toString();
            exeCmd(commandStr);
            logPo.setScriptOutputPath(REMOTEPATH + ":" + "~/web-monitor/probeLogs/" + PROBEID + "/" + String.valueOf(task.getTaskId()) + "/" + now.toString());
            //??????har??????
            resolveHar(thisLogPath + "/" + "network.har", logPo);

            //System.out.println(logPo.toString());

            //?????????????????????
            logPoMapper.insertSelective(logPo);
        }


        //        harReader = new HarReader(new DefaultMapperFactory());

//        DockerClientUtils dockerClientUtils = new DockerClientUtils();
//        //??????Docker?????????
//        DockerClient client = dockerClientUtils.connectDocker("tcp://localhost:2375");
//        //????????????(??????????????????????????????????????????dockerfile?????????image)
//        CreateContainerResponse container = dockerClientUtils.createContainers(client,
//                String.valueOf(task.getTaskId()),"web-monitor");
//        //????????????
//        dockerClientUtils.startContainer(client,container.getId());
//        dockerClientUtils.stopContainer(client,container.getId());
//        dockerClientUtils.removeContainer(client,container.getId());
    }

    public void resolveHar(String harPath, LogPo log) throws HarReaderException {
        //??????har??????
        HarReader harReader = new HarReader();
        Har har = harReader.readFromFile(new File(harPath));
//        System.out.println(har.getLog().getCreator().getName());

        //????????????????????????
        Long startedDateTime = har.getLog().getPages().get(0).getStartedDateTime().getTime();
        Long endTime = startedDateTime;

        //??????????????????
        List<HarEntry> entries = har.getLog().getEntries();
        Integer totalNNum = entries.size();
        Integer okNum =
                Math.toIntExact(entries.stream().filter(entry -> entry.getResponse().getStatus() == 200).count());
        for (HarEntry harEntry : entries) {
            Long curEndTime = harEntry.getStartedDateTime().getTime() + harEntry.getTime();
            if (curEndTime > endTime) {
                endTime = curEndTime;
            }
        }

        Long totalTime = endTime - startedDateTime;

        Double availability = (double) (int) okNum / totalNNum;

        log.setTotalTime(totalTime);
        log.setAvailability(availability);
        log.setTotalNum(totalNNum);
    }

    public static void exeCmd(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //?????????????????????????????????
    public static List<TaskPo> getFileContext(String path) throws Exception {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.trim().length() > 2) {
                list.add(str);
            }
        }
        return list.stream().map(taskString -> JSONObject.parseObject(taskString, TaskPo.class)).collect(Collectors.toList());
    }

    //?????????????????????????????????
    public static void writeFileContext(List<TaskPo> taskPoList, String path) throws Exception {
        File file = new File(path);
        //???????????????????????????
        if (!file.isFile()) {
            file.createNewFile();
        }
        List<String> strings = taskPoList.stream().map(JSONObject::toJSONString).collect(Collectors.toList());
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        if (System.getProperty("os.name").equals("Windows")) {
            for (String l : strings) {
                writer.write(l + "\r\n");
            }
        } else {
            for (String l : strings) {
                writer.write(l + "\n");
            }
        }
        writer.close();
    }

    public static void main(String[] args) {
        String path = "./locallogs/1/14/1642682157064/network.har";
        File file = new File(".");
        for(File f:file.listFiles()){
            System.out.println(f.getAbsoluteFile());
        }
    }
}
