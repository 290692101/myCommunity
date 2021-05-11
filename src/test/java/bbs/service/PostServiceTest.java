package bbs.service;

import bbs.dao.UserTest;
import com.bbs.bbsApp;
import com.bbs.entity.Post;
import com.bbs.entity.Topic;
import com.bbs.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = bbsApp.class)
public class PostServiceTest {
    @Autowired
    PostService ps;
    final private Logger logger= LoggerFactory.getLogger(UserTest.class);

    @Test
   /** 测试浏览所有主体帖
    *
    */
    public void testViewTopics(){
        List<Topic>res= ps.selectTopics(0,5);
    }

    @Test
    /**测试浏览单个主题帖中的内容
     * */
    public void testViewTopicAndPost(){
        List<Post>res=ps.selectPosts(0,10,5,1,1);

    }

    @Test
    /**测试发帖功能*/
    public void testCreateTopic() throws InterruptedException {
       /* for(int i=0;i<10;i++) {
            Thread.sleep(1000);
            ps.createTopic("这个帖子是测试主题帖发布服务第"+i+"个测试数据0507", "lch", "我是6号！ 自古一楼不说事！"
                    );
        }*/
        ps.createTopic("测试数据05052251", "lch", "我是lch！ 自古一楼不说事！"
        );

    }

    @Test
    /**测试回帖功能*/
    public void testReplyTopic(){
        //ps.replyTopic(5,6,"我是六号 我是4楼");
        ps.replyTopic(43,"lch","我是1号 我是几楼 我来水点经验");
    }

    @Test
    /**测试页数计算功能
     *
     */
    public void testCountPages(){
        int res=ps.getTopicPageNum(4);
        logger.warn(String.valueOf(res));
    }



}
