package com.yong.mark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yong.a.liang
 */
@SpringBootApplication
@EnableCaching
public class MarkServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkServiceApplication.class, args);
    }


}

