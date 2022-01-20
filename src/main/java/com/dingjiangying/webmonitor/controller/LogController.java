package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.dao.LogPoMapper;
import com.dingjiangying.webmonitor.dao.TaskPoMapper;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.po.*;
import com.dingjiangying.webmonitor.util.Util;
import com.dingjiangying.webmonitor.vo.LogVo;

import java.io.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private TaskPoMapper taskMapper;

    @Autowired
    private LogPoMapper logMapper;

    @Autowired
    private UserPoMapper userPoMapper;


    @Autowired
    ResourceLoader resourceLoader;

    @RequestMapping("/task/{taskId}")
    public String listByTask(@PathVariable Integer taskId, Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));

        LogPoExample example = new LogPoExample();
        if (taskId != null) {
            example.createCriteria().andTaskIdEqualTo(taskId);
        }

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
            vo.setAvailability(String.format("%.2f", po.getAvailability() * 100) + "%");
            vo.setTotalTime(String.valueOf(po.getTotalTime()) + "ms");

            logVos.add(vo);
        }
        model.addAttribute("logs", logVos);
        model.addAttribute("tag", "task");
//        System.out.println(taskId);
        return "log";
    }


    @RequestMapping("/unread")
    public String getUnreadLogs(Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));

        //找userId
        UserPoExample userPoExample = new UserPoExample();
        UserPoExample.Criteria userPoExampleCriteria = userPoExample.createCriteria();
        userPoExampleCriteria.andUserIdEqualTo(Util.getCurrentUserId(session));
        List<UserPo> users = userPoMapper.selectByExample(userPoExample);
        UserPo userPo = users.get(0);

        //找user的全部任务
        TaskPoExample taskPoExample = new TaskPoExample();
        TaskPoExample.Criteria taskPoExampleCriteria = taskPoExample.createCriteria();
        taskPoExampleCriteria.andUserIdEqualTo(userPo.getUserId());
        List<TaskPo> taskPos = taskMapper.selectByExample(taskPoExample);
        List<Integer> taskIds = taskPos.stream().map(TaskPo::getTaskId).collect(Collectors.toList());


        if (!CollectionUtils.isEmpty(taskIds)) {
            //找这些任务的全部日志
            LogPoExample logPoExample = new LogPoExample();
            LogPoExample.Criteria logPoExampleCriteria = logPoExample.createCriteria();
            logPoExampleCriteria.andTaskIdIn(taskIds);
            logPoExample.setOrderByClause("timestamp ASC");
            List<LogPo> logPos = logMapper.selectByExample(logPoExample);

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
                vo.setAvailability(String.format("%.2f", po.getAvailability() * 100) + "%");
                vo.setTotalTime(String.valueOf(po.getTotalTime()) + "ms");

                logVos.add(vo);
            }
            model.addAttribute("logs", logVos);
            model.addAttribute("tag", "task");
        }
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
            vo.setAvailability(String.format("%.2f", po.getAvailability() * 100) + "%");
            vo.setTotalTime(String.valueOf(po.getTotalTime()) + "ms");

            logVos.add(vo);
        }
        model.addAttribute("logs", logVos);
        model.addAttribute("tag", "probe");
        //        System.out.println(taskId);
        return "log";
    }

    /**
     * 目的是在点击下载的时候拉到本地，但不跳转页面，不知道怎么搞
     *
     * @param logId
     * @param model
     */
    @RequestMapping("download/{logId}/{tag}")
    public String download(@PathVariable("logId") Integer logId, @PathVariable("tag") String tag, Model model) {
        //拉取全部该日志的全部输出
        LogPo logPo = logMapper.selectByPrimaryKey(logId);
        String scriptOutputPath = logPo.getScriptOutputPath();
        String localPathWithTimeStamp = scriptOutputPath.substring(scriptOutputPath.indexOf("probeLogs"));
        String localPath = scriptOutputPath.substring(scriptOutputPath.indexOf("probeLogs"),
                scriptOutputPath.lastIndexOf("/"));


        String timeStamp = scriptOutputPath.substring(scriptOutputPath.lastIndexOf("/"));
        File localDirWithTimeStamp = new File(localPathWithTimeStamp);
        if (!localDirWithTimeStamp.exists()) {
            String cmd = "mkdir -p " + localPath;
            exeCmd(cmd);
            cmd = "scp -r " + scriptOutputPath + " " + localPath;
            exeCmd(cmd);
        }
//        cmd = "rm -rf probeLogs";
        model.addAttribute("myPath", localPath + timeStamp);
        model.addAttribute("tag", tag);
        return "logOutput";
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


    @RequestMapping("/download_file")
    public void downFileTemplate(String filename, HttpServletResponse response) throws IOException {
        String localFileName = filename.substring(filename.lastIndexOf("/") + 1);
        String absolutePath = filename;
        File file = new File(absolutePath);
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + localFileName);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
