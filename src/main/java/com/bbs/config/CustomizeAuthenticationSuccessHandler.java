package com.bbs.config;

import com.alibaba.fastjson.JSON;
import com.bbs.res.JsonResult;
import com.bbs.res.ResultTool;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//

/**
 * 登录成功处理器
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //可以在这里更新一下user的登录信息
        //SecurityProperties.User userDetails = (SecurityProperties.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //自定义的一些业务

        //返回json数据
        JsonResult result = ResultTool.success();
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
        System.out.println(Arrays.toString(httpServletRequest.getCookies()));
        System.out.println("登录成功 当前用户登录对应的sessionId为："+httpServletResponse.getHeader("Set-Cookie"));


    }
}
