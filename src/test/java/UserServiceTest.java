import com.ch.ch6_1.Ch61Application;
import com.ch.ch6_1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//自定义service的单元测试
@RunWith(SpringRunner.class)
//在这里写应用的启动类

@SpringBootTest(classes = Ch61Application.class)

public class UserServiceTest {
    //注入要测试的service
    @Autowired
    private UserService userService;

    //该注解可以模拟实现service执行
    
    //@MockBean
    //private VitualService vitualService;


    @Test
    public void testUserService(){
        userService.findAll();
    }

}
