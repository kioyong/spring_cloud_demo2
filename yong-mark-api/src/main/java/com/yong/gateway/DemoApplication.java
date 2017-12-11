package com.yong.gateway;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
@EnableHystrix
//@EnableZuulProxy
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.HEADERS ;
  }
}

