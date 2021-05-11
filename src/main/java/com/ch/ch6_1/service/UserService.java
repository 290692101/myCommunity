package com.ch.ch6_1.service;

import com.ch.ch6_1.entity.MyUser;

import java.util.List;
public interface UserService {
	public void saveAll();
	public List<MyUser> findAll();
	public MyUser findByUname(String uname);
	public List<MyUser> findByUnameLike(String uname);
	public MyUser getOne(int id);
	public List<MyUser> saveOne(String uname,String sex,String age);
}
