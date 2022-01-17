package com.dingjiangying.webmonitor.service;

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

    @Scheduled(fixedRate = 20000)//20s一次
    public void sendmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("邮件发送测试");
        simpleMailMessage.setText("测试下");
        simpleMailMessage.setFrom("1104349906@qq.com");
        simpleMailMessage.setTo("2000022759@stu.pku.edu.cn");
        javaMailSender.send(simpleMailMessage);
    }

}
