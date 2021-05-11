package com.ch.ch6_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//用户与权限的多对多关系测试


//实体注解
@Entity
@Table(name="user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键

    //两个属性
    private String uname;
    private String password;

    //多对多的关系注解
    //User端为多对多关系的维护端
    @ManyToMany
    private List<Authority> authorityList;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
