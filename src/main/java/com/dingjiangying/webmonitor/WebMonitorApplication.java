package com.dingjiangying.webmonitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@ServletComponentScan
public class WebMonitorApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebMonitorApplication.class, args);
    }



}
