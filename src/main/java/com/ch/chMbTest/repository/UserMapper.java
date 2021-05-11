package com.ch.chMbTest.repository;

import com.ch.chMbTest.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
//将mapper默认视为repository
//数据访问层

@Mapper
public interface UserMapper {
    //查找元素*************************************************************
    //数据访问层就一个方法 返回user表中的所有user
    User Sel(int id);
    //这个方法是使用resultMap配置的
    User selectById2(int id);



    //增加一个返回多个对象的方法
    List<User> GetAll();
    //根据id或用户名来选取元素
    User selectByIdOrUserName(User user);

    //根据一个条件的集合来返回结果的一个集合
    //传入一个id的集合 返回
    List<User> selectByIdList(List<Integer> idList);

    //高级查询 一对一
    //根据id查询用户和用户对应的角色
    User selectUserAndRoleById(int id);
    //resultMap实现根据id查询用户和用户对应的角色
    User selectUserAndRoleById2(int id);
    //嵌套查询实现一对一
    User selectUserAndRoleByIdSelect(int id);

    //高级查询 一对多
    //返回所有的用户及其对应的角色
    List<User> selectAllUserAndRoles();
    //嵌套查询实现 返回所有的用户及其对应的角色和权限
    List<User> selectAllUserAndRolesByUserId();

    //使用存储过程实现查找用户 没有返回值 直接传入对象 传出的参数自动映射到该对象中
    void selectUserById(User user);

    //使用存储过程实现基于用户名实现分页查询
    //多个入参使用map？
    List<User> selectUserPage(Map<String,Object> params);



    //增加元素*************************************************************
    //返回值为int 该int值为添加到sql表中的行数，不一定是主键哟
    int add(User user);

    //添加一个元素list
    int insertList(List<User> userList);

    //使用存储过程 增加用户 以及在ur表中增加
    //传入的参数为用户的普通参数以及该用户拥有的角色们
    //返回的参数为新建的该用户的id

    int insertUserAndRoles(User user,String roleIds);


    //修改元素*************************************************************
    int update(User user);


    //使用foreach 实现输入一个map的动态修改
    //String为要修改的列名 Object为各个类型的value值

    int updateByMap(Map<String,Object> map);


    //删除元素*************************************************************
    //根据主键删除
    int deleteById(int id);
    //使用存储过程删除
    int deleteUserById(int id);



}
