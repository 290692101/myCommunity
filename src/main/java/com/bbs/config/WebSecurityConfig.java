package com.bbs.config;

import com.bbs.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
/**
 * security的配置类
 *
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //匿名用户访问无权限资源时的异常
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    //登录成功
    @Autowired
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;
    //登录失败
    @Autowired
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
    //登出成功
    @Autowired
    CustomizeLogoutSuccessHandler logoutSuccessHandler;
    //自定义的登录拦截器
//    @Autowired
//    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter;

    //注入会话管理
    @Autowired
    CustomizeSessionInformationExpiredStrategy customizeSessionInformationExpiredStrategy;



    //加载userService
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式等
        //super.configure(auth);
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭什么默认保护
        http.cors().and().csrf().disable();

        //http相关的配置，包括登入登出、异常处理、会话管理等
        //super.configure(http);
        //http.authorizeRequests().mvcMatchers("/topics");

        http.authorizeRequests().
                antMatchers(HttpMethod.POST,"/topics").hasAuthority("普通用户").
                antMatchers(HttpMethod.POST,"/posts").hasAuthority("普通用户").
                antMatchers(HttpMethod.PUT,"/users").hasAuthority("普通用户").
                //异常处理(权限拒绝、登录失效等)
                and().exceptionHandling().
        //匿名用户访问无权限资源时的异常处理;
                authenticationEntryPoint(authenticationEntryPoint).
                //登入
                        and().formLogin().
                permitAll().//允许所有用户
                successHandler(authenticationSuccessHandler).//登录成功处理逻辑
                failureHandler(authenticationFailureHandler).//登录失败处理逻辑
                //登出
                        and().logout().
                permitAll().//允许所有用户
                logoutSuccessHandler(logoutSuccessHandler).//登出成功处理逻辑
                deleteCookies("JSESSIONID").//登出之后删除cookie
                //会话管理
                and().sessionManagement().
                maximumSessions(1).//会话信息过期策略会话信息过期策略(账号被挤下线)
                expiredSessionStrategy(customizeSessionInformationExpiredStrategy);

    }

    //设置密码加密
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        //带salt的强哈希函数 默认情况下使用加盐的哈希函数对密码进行哈希，
        // 这个盐，也进入了哈希的结果中，方便和明文比对
        return new BCryptPasswordEncoder();
    }

}
