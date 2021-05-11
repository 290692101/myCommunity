package com.bbs.dao;

import com.bbs.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TopicMapper {

    //根据主题帖id查找用户
    Topic selectTopicByTopicId(int topicId);

    //分页查询所有主题帖

    /**
     * 分页查询所有主题帖(浏览)
     * * 分页查询所有主题帖(管理)userId不为0
     *使用动态sql实现

     * @param offset 每页的起始索引
     * @param limit  每页显示多少条数据
     * @return
     */
    List<Topic> selectTopics( int offset, int limit,int userId);

    /**
     * 返回主题帖总数
     * @return
     */
    int getTopicCount();




    //增加一个topic
    /**
     * 插入主题帖（发帖）
     * @param topic
     * @return
     */
    int insertTopic(Topic topic);

    //改
    /**根据一个map动态的修改topic的所有内容*
     *
     * 这个方法拉了 暂时没用上 等着权限管理模块的时候再调把
     */

    int updateTopicByMap(Map<String,Object> map);

    /**修改主题帖的浏览数
     *
     * */
    int updateTopicViews(int topicId);

    /**
     *
     * @param topicId id
     * @return 修改主题帖的回复数
     */
    int updateTopicReplies(int topicId);

}
