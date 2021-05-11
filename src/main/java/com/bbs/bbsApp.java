package com.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置扫描mybatis接口的包路径
@MapperScan(basePackages = {"com.bbs.dao"})

public class bbsApp {
    public static void main(String[] args) {
        SpringApplication.run(com.bbs.bbsApp.class, args);
    }

}
