package com.ch.ch6_1.repository;
//用户与权限中的权限的持久层代码

import com.ch.ch6_1.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承jpa接口
public interface AuthorityRespository extends JpaRepository <Authority,Integer>{
    /*
    * 根据用户id查找 用户拥有的权限
    * 相当于jpql
    * select authrity a
    * from a
    * inner join a.userList u
    * where u.id=?1
    *
    * */

    //返回类型是权限类对应的List


    public List<Authority> findByUserList_id(Integer id);

    /*
     * 根据用户name查找 用户拥有的权限
     *相当于jpql
     * select a
     * from authrity a
     * inner join a.userList u
     * where u.name=?1
     * */
    //返回类型是权限类对应的List

    public List<Authority> findByUserList_uname(String name);

    //在这里可以使用@query注释来自定义查询方法








}
