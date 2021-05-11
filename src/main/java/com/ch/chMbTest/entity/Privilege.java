package com.ch.chMbTest.entity;
//权限实体类
//和角色是一对多的关系 一个角色可以有多个权限

public class Privilege {

private int id;
private String privilegeName;
private String privilegeUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
