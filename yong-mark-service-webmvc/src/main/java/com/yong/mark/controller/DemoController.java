package com.yong.mark.controller;

import com.yong.mark.model.HotPlayerPatron;
import com.yong.mark.model.HotPlayerSummary;
import com.yong.mark.model.PatronValue;
import com.yong.mark.repository.MarkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@RestController
@Slf4j
public class DemoController {


//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//    public RestTemplate getRestTemplate(@Autowired RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }

    @Autowired
    private MarkRepository markRepository;

    @Value("${yong.string}")
    private String testString;

    @GetMapping("/hello/{name}")
    private String hello(@PathVariable("name") String name) {
//        restTemplate.postForEntity("http://localhost:8080/hello",name,null );
//        return forObject;
        return "hello from mark service webmvc!5222 552!" + name;
    }

    @GetMapping("/error1")
    private String error() {
        throw new RuntimeException("oh !~!@#!");
    }

    @GetMapping("/getconfig")
    private String getConfig() {
        log.debug("testString = {}", testString);
        return "testString = " + testString;
    }

    @GetMapping("/agg")
    private HotPlayerSummary testAggregate(){
        List<HotPlayerPatron> patronList= markRepository.findAggregateByCustom();
        HotPlayerSummary summary = new HotPlayerSummary();
        summary.setPatronList(patronList);
        long buyIn = patronList.stream().mapToLong(p -> p.getBuyIn()).sum();
        long dd = patronList.stream().mapToLong(p -> p.getDd()).sum();
        long hours = patronList.stream().mapToLong(p -> p.getHours()).sum();
        summary.setHours(hours);
        summary.setBuyIn(buyIn);
        summary.setDd(dd);
        return summary;
    }

    @GetMapping("/getLastValue")
    private List<PatronValue> testReduce(){
        return markRepository.findAggregateBuyReduce();
    }
}
