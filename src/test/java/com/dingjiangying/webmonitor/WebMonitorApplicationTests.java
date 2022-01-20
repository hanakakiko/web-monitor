package com.dingjiangying.webmonitor;

import com.dingjiangying.webmonitor.po.TaskPo;
import com.dingjiangying.webmonitor.service.ScheduledProbeTaskService;
import de.sstoehr.harreader.HarReaderException;
import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class WebMonitorApplicationTests {
//
////    @Autowired
////    private TaskPo taskPo;
////
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    ScheduledProbeTaskService scheduledProbeTaskService;
//
//    @Autowired
//    JavaMailSenderImpl javaMailSender;
//
//    @Test
//    void contextLoads() throws Exception {
////        System.out.println(task);
////        Connection connection = dataSource.getConnection();
////        System.out.println(connection);
////        connection.close();
////        testMail();
////        testPuppeteer();
//        scheduledProbeTaskService.pullTasks();
//    }
//
//    private void testPuppeteer() throws HarReaderException {
//        TaskPo taskPo = new TaskPo();
//        taskPo.setTaskId(500);
//        taskPo.setTaskUrl("https://www.baidu.com");
//        scheduledProbeTaskService.runTask(taskPo);
//    }
//
//    private void testMail(){
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setSubject("邮件发送测试");
//        simpleMailMessage.setText("测试下");
//        simpleMailMessage.setFrom("1104349906@qq.com");
//        simpleMailMessage.setTo("2000022759@stu.pku.edu.cn");
//        javaMailSender.send(simpleMailMessage);
//    }

}
