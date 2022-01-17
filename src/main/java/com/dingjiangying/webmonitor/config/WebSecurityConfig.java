package com.dingjiangying.webmonitor.config;

import com.dingjiangying.webmonitor.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * https://juejin.cn/post/6854573217940668430讲得不错
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserService;
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {//不推荐使用了，等会儿用encoding处理一下
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
    @Override
    //重写configure(HttpSecurity http)的方法，这里面来自定义自己的拦截方法和业务逻辑
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        System.out.println("用到一！！");
//        httpSecurity.authorizeRequests()
//                .antMatchers("/js/**","/css/**","/images/*","/fonts/**","/**/*.png","/**/*.jpg").permitAll()
//                .antMatchers("/","/login","/register","/login_form").permitAll()
////                .antMatchers("/task/list","/d;uid/*").permitAll()
//                .anyRequest().authenticated();
//                .and()
//                .formLogin()
//                .usernameParameter("username").passwordParameter("password")
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .defaultSuccessUrl("/task/list")
//                .and()
//                .rememberMe().rememberMeParameter("remember-me") //其实默认就是remember-me，这里可以指定更换
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")  //退出登录
//                .permitAll()
//                .and()
//                .csrf().disable();

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
