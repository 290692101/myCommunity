package com.ch.ch6_1.service;

import com.ch.ch6_1.entity.MyUser;

import java.util.List;

public interface DeleteService {
    public List<MyUser> deleteByUname(String uname);
}
