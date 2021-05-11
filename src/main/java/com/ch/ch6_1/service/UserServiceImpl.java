package com.ch.ch6_1.service;

import com.ch.ch6_1.entity.MyUser;
import com.ch.ch6_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;//依赖注入数据访问层
	@Override
	public void saveAll() {
		MyUser mu1 = new MyUser();
		mu1.setUname("lch");
		mu1.setUsex("boy");
		mu1.setAge(88);
		MyUser mu2 = new MyUser();
		mu2.setUname("jxl");
		mu2.setUsex("girl");
		mu2.setAge(18);
		MyUser mu3 = new MyUser();
		mu3.setUname("wty");
		mu3.setUsex("boy");
		mu3.setAge(99);
		List<MyUser> users = new ArrayList<MyUser>();
		users.add(mu1);
		users.add(mu2);
		users.add(mu3);
		//调用父接口中的方法saveAll
		userRepository.saveAll(users);
	}
	@Override
	public List<MyUser> findAll() {
		//调用父接口中的方法findAll
		return userRepository.findAll();
	}
	@Override
	public MyUser findByUname(String uname) {
		return userRepository.findByUname(uname);
	}
	@Override
	public List<MyUser> findByUnameLike(String uname) {
		return userRepository.findByUnameLike("%" + uname + "%");
	}
	@Override
	public MyUser getOne(int id) {
		//调用父接口中的方法getOne
		return userRepository.getOne(id);
	}

	@Override
	public List<MyUser> saveOne(String uname, String sex, String age) {
		MyUser mu1 = new MyUser();
		mu1.setUname(uname);
		mu1.setUsex(sex);
		mu1.setAge( Integer.parseInt(age));

		List<MyUser> users = new ArrayList<MyUser>();
		users.add(mu1);
		userRepository.saveAll(users);
		return users;
	}


}
