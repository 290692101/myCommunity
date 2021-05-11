package com.ch.ch6_1.service;

import com.ch.ch6_1.entity.Authority;
import com.ch.ch6_1.entity.User;
import com.ch.ch6_1.repository.AuthorityRespository;
import com.ch.ch6_1.repository.NuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//service接口的实现类
//真正的service层

@Service
public class UserAndAuthorityServiceImpl implements UserAndAuthorityService{
    //注入持久层
    @Autowired
    //权限类的持久层
    private AuthorityRespository authorityRespository;

    //用户类的持久层
    @Autowired
    private NuserRepository nuserRepository;


    @Override
    public void saveAll() {
        //初始化方法

        //初始化四个权限
        Authority at1=new Authority();
        at1.setName("add");
        //可以用持久层的方法保存单个对象
        authorityRespository.save(at1);

        Authority at2=new Authority();
        at2.setName("delete");
        authorityRespository.save(at2);

        Authority at3=new Authority();
        at3.setName("update");
        authorityRespository.save(at3);

        Authority at4=new Authority();
        at4.setName("find");
        authorityRespository.save(at4);

        //初始化两个用户
        //用户端算是维护端
        //所以需要手动设定他们的list来表示他们的关系

        User u1=new User();
        u1.setUname("lch");
        u1.setPassword("123");
        List<Authority> uList1=new ArrayList<>();
        uList1.add(at1);
        uList1.add(at2);
        uList1.add(at3);
        uList1.add(at4);

        u1.setAuthorityList(uList1);
        nuserRepository.save(u1);

        User u2=new User();
        u2.setUname("jxl");
        u2.setPassword("234");
        List<Authority> uList2=new ArrayList<>();
        uList2.add(at1);

        u2.setAuthorityList(uList2);
        nuserRepository.save(u2);








    }

    @Override
    public List<Authority> findByUserList_id(Integer id) {
        return authorityRespository.findByUserList_id(id);
    }

    @Override
    public List<Authority> findByUserList_name(String name) {
        return authorityRespository.findByUserList_uname(name);
    }

    @Override
    public List<User> findByAuthorityList_id(Integer id) {
        return nuserRepository.findByAuthorityList_id(id);
    }

    @Override
    public List<User> findByAuthorityList_name(String name) {
        return nuserRepository.findByAuthorityList_name(name);
    }


}
