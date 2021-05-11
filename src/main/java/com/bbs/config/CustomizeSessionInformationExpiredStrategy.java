package com.bbs.config;

import com.alibaba.fastjson.JSON;
import com.bbs.res.JsonResult;
import com.bbs.res.ResultCode;
import com.bbs.res.ResultTool;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**会话信息过期策略
 *
 */
@Component
public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        //调用res中的工厂类 获取session被其他人挤下线对应的json
        JsonResult result= ResultTool.fail(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
        //获取response对象
        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
        //将json写入返回的content中
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));

    }
}
