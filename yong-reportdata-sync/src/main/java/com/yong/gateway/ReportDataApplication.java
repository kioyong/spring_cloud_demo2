package com.yong.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author LiangYong
 * @date 2018/01/10
 */

@SpringBootApplication
@EnableBinding
public class ReportDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportDataApplication.class, args);
    }
    
}

