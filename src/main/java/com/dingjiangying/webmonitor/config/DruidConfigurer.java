package com.dingjiangying.webmonitor.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.alibaba.druid.support.http.ResourceServlet.*;

@Configuration
public class DruidConfigurer {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDateSource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        Map<String,String> initParameters = new HashMap<>();

        //只有正确用户名密码才能访问(可是不需要登陆直接就跳转到index.html了啊？？除非手动输入/druid/login.html)
        initParameters.put(PARAM_NAME_USERNAME, "dingjiangying");
        initParameters.put(PARAM_NAME_PASSWORD, "2020beidaruanwei");

        //这句使得所有人都可以访问
        initParameters.put(PARAM_NAME_ALLOW, "");

        statViewServletServletRegistrationBean.setInitParameters(initParameters);
        return statViewServletServletRegistrationBean;
    }

    //配置 Druid 监控 之  web 监控的 filter
    //WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
        bean.setInitParameters(initParams);

        //"/*" 表示过滤所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
