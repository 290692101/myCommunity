package bbs.service;

import com.bbs.bbsApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = bbsApp.class)
public class SecurityServiceTest {
    @Test
    public void contextLoads() {
        PasswordEncoder pw= new BCryptPasswordEncoder();
        //加密
        String encode=pw.encode("123");
        System.out.println(encode);
        //比较密码
        boolean matches=pw.matches("123",encode);
        System.out.println("==============================");
        System.out.println(matches);

       /* String encode2=pw.encode("123");
        System.out.println(encode2);
        boolean matches2=pw.matches("123",encode2);
        System.out.println("==============================");
        System.out.println(matches2);
        /*
        int off=4;
        encode2.substring(off + 3, off + 25)
        */

/*        System.out.println(BCrypt.hashpw("123", encode2));*/
        PasswordEncoder pw2= new BCryptPasswordEncoder();
        boolean matches2=pw2.matches("123",encode);
        System.out.println("==============================");
        System.out.println(matches2);


    }

}
