package bbs.dao;

import com.bbs.bbsApp;
import com.bbs.dao.PostMapper;
import com.bbs.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

//自定义数据访问层的单元测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = bbsApp.class)
public class PostTest {
    //依赖注入post的dao层
    @Autowired
    PostMapper pm;

    final private Logger logger= LoggerFactory.getLogger(UserTest.class);

    //测试发普通帖
    @Test
    public void postInsert() {


        Post pt1=new Post();
        pt1.setContent("回帖！有人的！我是5号！3");
        pt1.setCreateTime(new Date());
        pt1.setTopicId(4);
        pt1.setType(2);
        pt1.setUserId(5);

        pm.insertPost(pt1);
        logger.warn("发帖后该帖子的主键为"+pt1.getId());

    }
    //测试浏览主题帖内容
    @Test
    public void lookTopicPosts(){
        //List<Post> res=pm.selectTopicPosts(0,10,4,0,1);
        List<Post> res=pm.selectTopicPosts(0,10,4,0,0);
    }

}

