package com.yong.mark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    private String hello() {
        return "hello from mark service webmvc!";
    }
}
