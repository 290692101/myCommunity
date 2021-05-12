package bbs.service;

import bbs.dao.UserTest;
import com.alibaba.fastjson.JSON;
import com.bbs.bbsApp;
import com.bbs.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = bbsApp.class)
public class ManagerServiceTest {
    @Autowired
    ManagerService ms;

    final private Logger logger= LoggerFactory.getLogger(UserTest.class);

    @Test
    public void testInsertUser(){
       // JsonResult res=ms.insertUser("lch","000000");

        System.out.println(JSON.toJSONString(ms.insertUser("","000000")));
        System.out.println(JSON.toJSONString(ms.insertUser("lch","000000")));
        System.out.println(JSON.toJSONString(ms.insertUser("lch5556","")));
        System.out.println(JSON.toJSONString(ms.insertUser("jxl33","000000")));

    }

    @Test
    //测试根据用户名获取用户对象
    public void testGetUser(){
        logger.warn(ms.getUserByUsername("lch").toString());
    }

    @Test
    //测试根据用户id获取所有的Topic
    public void selectUserTopic(){
        ms.selectTopics(0,7,7);
    }

    @Test
    //测试修改密码服务
    public void updateUserPassword(){
        boolean flag=ms.updateUserPassword(1,"000000");
        logger.warn(String.valueOf(flag));
        flag=ms.updateUserPassword(1000,"000000");
        logger.warn(String.valueOf(flag));
    }

}
