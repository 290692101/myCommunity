package com.ch.ch6_1.repository;

import com.ch.ch6_1.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//数据访问层接口
//使用mybatis访问user类
//使用Mapper作为注解
//spring默认将mapper作为数据访问层

@Mapper
public interface MyUserRepository {
    public List<MyUser> findAll();

}
