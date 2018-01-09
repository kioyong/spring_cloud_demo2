package com.yong.mark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@RestController
public class DemoController {

    @GetMapping("/hello/{name}")
    private String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }
}
