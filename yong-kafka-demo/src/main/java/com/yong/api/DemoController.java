package com.yong.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @acthor yong.a.liang
 * @date 2017/12/18
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private DemoSource source;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("test/{name}")
    public String getHelloMessage(@PathVariable(name = "name") String name) {
        log.info("start get hello Message: {} ",name);
        source.output().send(MessageBuilder.withPayload(name).build());
//        MessageChannel channel = (MessageChannel)applicationContext.getBean("demoOut");
//        channel.gateway(MessageBuilder.withPayload(name).build());
        return "hello World! Send Stream successful " + name;
    }


    @StreamListener(DemoSink.DEMO_INPUT)
    public void handleIn(String name){
        log.info("handle kafka in message: {}",name);
    }
}
