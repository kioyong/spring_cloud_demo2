package com.yong.gateway;

import com.yong.resource.config.EnableYongResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
@EnableYongResourceServer
public class GateWayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GateWayApplication.class, args);
  }

}

