package com.ch.ch6_1.controller;

import com.ch.ch6_1.entity.Authority;
import com.ch.ch6_1.entity.User;
import com.ch.ch6_1.service.UserAndAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//返回json的控制器
@RestController
public class ManyToManyController {
    //注入服务层对象
    @Autowired
    private UserAndAuthorityService userAndAuthorityService;

    @RequestMapping("/saveManyToMany")
    public String save(){
        userAndAuthorityService.saveAll();
        return "用户与权限保存成功";
    }
    @RequestMapping("/findByAuthorityList_id")
    public List<User> findByAuthorityId(Integer id){
        return userAndAuthorityService.findByAuthorityList_id(id);

    }
    @RequestMapping("/findByAuthorityList_name")
    public List<User> findByAuthorityList_name(String name){
        return userAndAuthorityService.findByAuthorityList_name(name);
    }

    @RequestMapping("/findByUserList_id")
    public List<Authority> findByUserList_id(Integer id){
        return userAndAuthorityService.findByUserList_id(id);
    }

    @RequestMapping("/findByUserList_name")
    public List<Authority> findByUserList_name(String name){
        return userAndAuthorityService.findByUserList_name(name);
    }

}
