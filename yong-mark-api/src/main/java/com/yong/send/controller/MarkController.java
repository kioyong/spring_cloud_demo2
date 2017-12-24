package com.yong.gateway.controller;

import com.yong.gateway.client.MarkClient;
import com.yong.model.Mark;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiangYong
 * @date 2017/12/10
 */
@RestController
@AllArgsConstructor
public class MarkController{

    private final MarkClient client;

    @GetMapping("/")
    public String hello(){
        return client.hello();
    }

    @GetMapping("/mark")
    public List<Mark> getAllMrk(){
        return client.getAllMark();
    }

    @GetMapping("/test")
    public String testDevTools(){
        return "hello devTools->7";
    }
}
