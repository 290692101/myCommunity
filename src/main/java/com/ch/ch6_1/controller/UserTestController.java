package com.ch.ch6_1.controller;

import com.ch.ch6_1.entity.MyUser;
import com.ch.ch6_1.service.DeleteService;
import com.ch.ch6_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
public class UserTestController {
	@Autowired
	private UserService userService;

	//注入删除服务
	@Autowired
	private DeleteService deleteService;

	@RequestMapping("/save")
	//@ResponseBody
	public String save() {
		userService.saveAll();
		return "保存用户成功！";
	}
	@RequestMapping("/findByUname")
	public String findByUname(String uname, Model model) {
		model.addAttribute("title", "根据用户名查询一个用户");
		model.addAttribute("auser", userService.findByUname(uname));
		return "showAuser";
	}
	@RequestMapping("/getOne")
	public String getOne(int id) {

		MyUser one=userService.getOne(id);
		one.setAge(123);
		userService.saveAll();
		return "根据id查询一个用户\n";
	}
	@RequestMapping("/findAll")
	public List<MyUser> findAll(Model model){
		model.addAttribute("title", "查询所有用户");
		model.addAttribute("allUsers",userService.findAll());

		return userService.findAll();

	}
	@RequestMapping("/findByUnameLike")
	public String findByUnameLike(String uname, Model model){
		model.addAttribute("title", "根据用户名模糊查询所有用户");
		model.addAttribute("allUsers",userService.findByUnameLike(uname));
		return "showAll";
	}

	@RequestMapping("/getParam")
	public String getParam(String param1,String param2){
		return param1+param2;

	}

	@RequestMapping("/delete")
	public List<MyUser> deleteByUname(String uname){
		return deleteService.deleteByUname(uname);
	}

	@RequestMapping("/saveOne")
	public List<MyUser> saveOne(String uname, String sex, String age){
		return userService.saveOne(uname,sex,age);
	}
}
