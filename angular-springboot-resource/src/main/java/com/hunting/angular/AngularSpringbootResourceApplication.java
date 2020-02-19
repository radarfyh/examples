package com.hunting.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@RestController
public class AngularSpringbootResourceApplication extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
      .and()
        .authorizeRequests()
          .anyRequest().authenticated();
  }

  @RequestMapping("/")
  @CrossOrigin(origins = "*", maxAge = 3600,
      allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"})
  public Message home() {
    return new Message("这是一次严肃的测试。");
  }

  @Bean
  HeaderHttpSessionStrategy sessionStrategy() {
    return new HeaderHttpSessionStrategy();
  }

  public static void main(String[] args) {
    SpringApplication.run(AngularSpringbootResourceApplication.class, args);
  }

}
