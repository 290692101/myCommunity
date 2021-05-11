package bbs.dao;

import com.bbs.bbsApp;
import com.bbs.dao.UserMapper;
import com.bbs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//自定义数据访问层的单元测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = bbsApp.class)
public class UserTest {
    //依赖注入user的dao层
    @Autowired
    UserMapper um;

    final private Logger logger= LoggerFactory.getLogger(UserTest.class);

    //测试用户注册
    @Test
    public void userInsert(){
        User u1=new User();
        u1.setCreateTime(new Date());
        logger.warn("自动获取到的时间为"+u1.getCreateTime());
        u1.setUsername("lch77");
        u1.setEmail("290@qq.com");
        u1.setCredit(0);
        u1.setStatus(0);
        u1.setType(0);
        PasswordEncoder bp=new BCryptPasswordEncoder();
        u1.setPassword(bp.encode("123456"));

        logger.warn("开始写入数据库");
        int res=um.insertUser(u1);
        logger.warn("插入后返回的数据为"+res);
        logger.warn("主键为"+u1.getId());



    }

    //测试修改用户积分
    @Test
    public void userCredit(){
        um.updateUserCredit(1,-5);
    }

    //测试根据用户名查找用户
    @Test
    public void selectUserByUname(){
        User res=um.selectUserByUsername("lch6");
    }



}
