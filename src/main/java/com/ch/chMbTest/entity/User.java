package com.ch.chMbTest.entity;
//实体类
//一对多中的一 在属性中加入role属性

import java.util.List;

public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
    //添加邮箱列
    private String eMail;
    //添加角色列 暂时是一对一 一个用户一个角色
    private Role role;

    //一对多的关系 所以user这边有一个role的list
    private List<Role> roleList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
