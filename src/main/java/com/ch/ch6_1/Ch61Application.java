package com.ch.ch6_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Ch61Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch61Application.class, args);
	}

}
