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


//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//    public RestTemplate getRestTemplate(@Autowired RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }

    @GetMapping("/hello/{name}")
    private String hello(@PathVariable("name") String name) {
//        restTemplate.postForEntity("http://localhost:8080/hello",name,null );
//        return forObject;
        return "hello from mark service webmvc!" + name;
    }

    @GetMapping("/error")
    private String error(){
        throw new RuntimeException("oh !~!@#!");
    }
}
