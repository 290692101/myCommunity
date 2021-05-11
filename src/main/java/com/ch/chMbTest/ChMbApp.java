package com.ch.chMbTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置扫描mybatis接口的包路径
@MapperScan(basePackages = {"com.ch.chMbTest.repository"})

public class ChMbApp {
    public static void main(String[] args) {
        SpringApplication.run(ChMbApp.class, args);
    }

}
