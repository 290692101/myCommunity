package bbs.dao;

import com.bbs.bbsApp;
import com.bbs.dao.TopicMapper;
import com.bbs.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//自定义数据访问层的单元测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = bbsApp.class)
public class TopicTest {
    //依赖注入user的dao层
    @Autowired
    TopicMapper tm;

    final private Logger logger= LoggerFactory.getLogger(UserTest.class);
    //测试查找topic
    @Test
    public void topicSelectByTopicId(){
        Topic res=tm.selectTopicByTopicId(5);
        logger.warn("5号帖子的楼主是"+res.getUserId());
    }

    //测试发帖
    @Test
    public void topicInsert() {
        Topic tc1=new Topic();
        tc1.setCreateTime(new Date());
        tc1.setDigest(0);
        tc1.setLastPost(tc1.getCreateTime());
        tc1.setTitle("发个帖子哦 有人吗？");
        tc1.setUserId(2);
        tc1.setViews(1);
        tc1.setReplies(0);
        tm.insertTopic(tc1);
        logger.warn("发帖后该帖子的主键为"+tc1.getId());
    }

    //测试浏览
    @Test
    public void topicSelect(){
        List<Topic> res=tm.selectTopics(7,10,0);
       // List<Topic> res=tm.selectTopics(0,10,2);
    }

    //测试动态修改topic
    @Test
    public void updateTopic(){
        /**根据一个map动态的修改topic的所有内容*/
        Map<String,Object> map=new HashMap<>();
        map.put("id",3);

        //获取浏览数 将浏览数加一


        //map.put("id",3);


    }

    //测试修改topic浏览数
    @Test
    public void updateTopicViews(){
        tm.updateTopicViews(4);
    }

    //测试修改topic回复数
    @Test
    public void updateTopicRples(){
        tm.updateTopicReplies(4);
    }

    //测试查找topic总数
    @Test
    public void getTopicNums(){
        int res=tm.getTopicCount();
        System.out.println(res);
    }



}
