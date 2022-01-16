//package com.dingjiangying.webmonitor.config;
//
//import com.alibaba.druid.support.http.StatViewServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Locale;
//
///**
// * 一些diy功能，交给springboot自动装配
// */
//@Configuration
//public class MyWebMvcConfigurer implements WebMvcConfigurer {
//
//    /**
//     * 自定义视图控制器跳转
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
//
//}
