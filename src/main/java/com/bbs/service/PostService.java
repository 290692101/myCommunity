package com.bbs.service;

import com.bbs.dao.PostMapper;
import com.bbs.dao.TopicMapper;
import com.bbs.dao.UserMapper;
import com.bbs.entity.Post;
import com.bbs.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帖子主体模块
 *
 * 浏览帖子
 * 发帖
 * 回帖
 *
 * */
@Service
public class PostService {
    //依赖注入dao
    @Autowired
    private PostMapper pm;
    @Autowired
    private TopicMapper tm;
    @Autowired
    private UserMapper um;

    /**
     * 浏览功能 浏览所有主题帖
     * */
    public List<Topic> selectTopics(int offset, int limit){
        List<Topic> res=tm.selectTopics(offset,limit,0);
        return res;
    }

    /**
     * * 浏览功能 浏览单个主题帖内容
     *      * 影响主题帖的浏览量 查看第一页会影响浏览量
     * @param offset 偏移
     * @param limit  个数
     * @param topicId 主题帖id
     * @param lz      只看楼主选项
     * @param desc    按时间倒序查看
     * @return 楼层的集合
     */
   public List<Post> selectPosts(int offset, int limit,int topicId,int lz,int desc){
        List<Post> res=pm.selectTopicPosts(offset,limit,topicId,lz,desc);
        if(offset==0){
            tm.updateTopicViews(topicId);

        }
        return res;


    }

    /**
     * 发帖
     * 流程 先发布topic 再发布topic中的一个post
    */
    /**
     * 发一个帖子用户得十分
     * @param title 帖子标题
     * @param username 用户名
     * @param content 帖子一楼内容
     */
    public void createTopic(String title,String username,String content){
        int userId=um.selectUserByUsername(username).getId();
        Topic tc=new Topic();
        //七个set来初始化一个新的主题帖
        tc.setTitle(title);
        tc.setReplies(0);
        tc.setViews(0);
        tc.setCreateTime(new Date());
        tc.setLastPost(tc.getCreateTime());
        tc.setDigest(0);
        tc.setUserId(userId);
        //先发布topic
        tm.insertTopic(tc);
        //获取这个新的主题帖的id
        //logger.warn("发帖后该帖子的主键为"+tc.getId());
        int nid=tc.getId();
        Post pt=new Post();
        pt.setUserId(userId);
        pt.setType(1);//设置为主题帖
        pt.setTopicId(nid);
        pt.setCreateTime(new Date());
        pt.setContent(content);
        pm.insertPost(pt);
        //用户发帖加十分
        um.updateUserCredit(userId,10);

    }

    /**
     *
     * @param topicId 主题帖子id
     * @param username  用户名
     * @param content  回复帖内容
     */

    public void replyTopic(int topicId,String username,String content){
        //帖子的简单初始化
        Post pt=new Post();
        //根据用户名查找用户id

        int userId=um.selectUserByUsername(username).getId();

        pt.setUserId(userId);

        pt.setTopicId(topicId);
        pt.setCreateTime(new Date());
        pt.setContent(content);

        //根据topicId获取楼主id
        Topic tp=tm.selectTopicByTopicId(topicId);
        int lzId=tp.getUserId();
        //判断是否是楼主想补充 如果是楼主 设置type为1
        if(lzId==userId){
            pt.setType(1);

        }else{
            //回复帖的类型是2
            pt.setType(2);

        }
        pm.insertPost(pt);


        //更新主题帖表的回复数 回复时间
        //回复时间就可以调库 因为是直接写入全新的值
        Map<String,Object> updateMap=new HashMap<>();
        //先向map中加入id
        updateMap.put("topic_id",topicId);
        //再更改回复时间
        updateMap.put("last_post",pt.getCreateTime());
        tm.updateTopicByMap(updateMap);

        //更改回复数
        tm.updateTopicReplies(topicId);
        //禁止给自己刷分
        if(lzId!=userId) {
            //修改楼主和回帖人的积分
            um.updateUserCredit(userId, 3);


            um.updateUserCredit(lzId, 1);
        }

    }

    /**
     * 计算主题帖的总页数
     * @param innerPageNum 一页的个数
     * @return
     */
    public int getTopicPageNum(int innerPageNum){
        int pageNum=0;

        int count=tm.getTopicCount();
        //整数相除并向上取整
         pageNum = (int)Math.ceil((double)count/innerPageNum);

        return pageNum;
    }

}
