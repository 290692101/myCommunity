package com.bbs.dao;

import com.bbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    //增加一个user
    /**
     * 插入用户（注册）
     * @param user
     * @return
     */
    int insertUser(User user);

    int updateUserCredit(int userId,int addValue);

    /**
     * 根据用户名查询user 保证只有一个结果返回
     * @param username
     * @return
     */
    User selectUserByUsername(String username);

}
