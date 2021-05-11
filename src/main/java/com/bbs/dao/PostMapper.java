package com.bbs.dao;

import com.bbs.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    //分页查询所有post
    /**
     * 分页查询一个主题帖下的所有帖(浏览主题帖)

     *使用动态sql实现
     * * * 分页查询 只看楼主(浏览主题帖)lz==1
     * * * * 分页查询 倒序(浏览主题帖)desc==1

     * @param offset 每页的起始索引
     * @param limit  每页显示多少条数据
     *     @param  topicId 对应的主题帖id
     * @param lz 只看楼主==1
     * @param desc 倒序查看==1
     *
     * @return
     */
    List<Post> selectTopicPosts(int offset, int limit, int topicId,int lz,int desc);


    //增加一个post
    /**
     * 插入普通帖（回帖）
     * @param post
     * @return
     */
    int insertPost(Post post);




}
