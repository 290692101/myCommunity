package com.ch.ch6_1.repository;

import com.ch.ch6_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//用户与权限中的用户的持久层代码

//继承jpa接口
public interface NuserRepository extends JpaRepository<User,Integer> {
    //根据权限id
    //查找拥有该权限的用户

    //相当于jpql语句
    /*
    * select u
    *   from user u
    *       inner join u.authorlist a
    *           where a.id=?1
    * */

    //返回类型是user对应的list

    public List<User> findByAuthorityList_id(Integer id);

    //根据权限名查找拥有该权限的用户
    //相当于jpql语句:
    /*select u
        from user u
            inner join u.authoritylist a
                where a.name=?1
     */

    //返回类型是user对应的list
    public List<User> findByAuthorityList_name(String name);





}
