package com.dingjiangying.webmonitor;

import com.dingjiangying.webmonitor.service.ScheduledProbeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.sql.DataSource;

import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class WebMonitorApplication {


    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("probeid=")) {
                ScheduledProbeTaskService.PROBEID = new Integer(args[i].substring(8));
            }
        }
        SpringApplication.run(WebMonitorApplication.class, args);
    }


}
