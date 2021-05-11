package com.ch.ch6_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})

public class Authority {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键

    //一个属性
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authorityList")
    @JsonIgnore
    private List<User> userList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
