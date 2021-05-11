package com.ch.ch6_2.repository;
//继承jpa接口 传入student类作为访问层

import com.ch.ch6_1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface StudentRespository extends JpaRepository<Student,Integer> {
    //自定义接口查询方法
    //暴露为rest资源
    //注解里的两个参数是什么意思？
    //path定义的是对应所在的url路径
    //rel对应的是返回路径


    @RestResource(path ="snameStartsWith" ,rel ="snameStartsWith" )
    List<Student> findBySnameStartsWith(@Param("sname") String sname);


}
