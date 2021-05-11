package com.ch.ch6_1.service;

import com.ch.ch6_1.entity.MyUser;
import com.ch.ch6_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeleteServiceImpl implements DeleteService{
    @Autowired
    private UserRepository userRepository;//依赖注入数据访问层

    @Override
    public List<MyUser> deleteByUname(String uname){
        return userRepository.deleteByUname(uname);
    }
}
