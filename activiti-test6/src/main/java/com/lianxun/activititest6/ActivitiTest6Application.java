package com.lianxun.activititest6;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class ActivitiTest6Application {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiTest6Application.class, args);
	}
	@GetMapping("/test")
    public User sayHello(){
        System.out.println("----采用angularjs----");
        User user = new User();
        user.setName("admin");
        user.setPassword("123456");
        return user;
    }
}
