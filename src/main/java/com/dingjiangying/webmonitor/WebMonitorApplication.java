package com.dingjiangying.webmonitor;

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
        SpringApplication.run(WebMonitorApplication.class, args);
    }



}
