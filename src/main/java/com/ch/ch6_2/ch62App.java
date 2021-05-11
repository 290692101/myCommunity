package com.ch.ch6_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//增加扫描实体类的注解
@EntityScan("com.ch")


@SpringBootApplication
public class ch62App {

    public static void main(String[] args) {
        SpringApplication.run(com.ch.ch6_2.ch62App.class, args);
    }

}
