package com.ch.ch6_1.service;
//定义用户与权限模块的service层接口

import com.ch.ch6_1.entity.Authority;
import com.ch.ch6_1.entity.User;

import java.util.List;

public interface UserAndAuthorityService {
    //初始化方法
    public  void  saveAll();
    //根据user查找权限
    public List<Authority> findByUserList_id(Integer id);
    public List<Authority> findByUserList_name(String name);

    //根据权限查找user
    public List<User> findByAuthorityList_id(Integer id);
    public List<User> findByAuthorityList_name(String name);






}
