package com.ch.chMbTest.entity;
//第二个实体类 与user是一对多的关系 一个user可以有多个role

import java.util.Date;
import java.util.List;

public class Role {
    //用户id
    private Integer id;

    //角色权限属性
    //private int enabled;
    private Enabled enabled;


    //与user的联系
    private int createBy;

    //创建时间 注意是date类型
    private Date createTime;

    //角色名
    private String roleName;

    //权限集合
    private List<Privilege> privilegeList;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }
}
