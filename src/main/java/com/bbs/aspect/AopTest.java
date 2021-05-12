package com.bbs.aspect;

//引入了aop包spring就会默认的启动aop功能
//???1
import com.bbs.res.JsonResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**统一日志记录
 *
 */
@Aspect //声明一个切面
@Component //让该切面成为spring容器管理的Bean
public class AopTest {
    //日志记录
    private static final Logger logger = LoggerFactory.getLogger((com.bbs.bbsApp.class));

    //定义切入点 通知增强哪些方法
    @Pointcut("execution( * com.bbs.controller.*.*(..))")
    private void myPointCut(){

    }

    @Before("myPointCut()")
    public void before(JoinPoint jp){
        //前置获取用户的连接信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return ;
        }
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteHost();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        logger.info(String.format("用户[%s], 在[%s], 访问了[%s].", ip, time, target));


    }

    @AfterReturning(pointcut="myPointCut()",returning="res")
    public void afterReturning(JoinPoint jp, JsonResult res){
        //后置返回给用户的返回结果
       // httpServletResponse
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return ;
        }
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteHost();

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
       // logger.info("方法执行完毕");

        logger.info(String.format("用户[%s], 在[%s], [%s]方法执行完毕.返回码为[%s]", ip, time, target,res.getErrorCode()));


    }
}
