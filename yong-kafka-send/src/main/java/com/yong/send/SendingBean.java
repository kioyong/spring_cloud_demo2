package com.yong.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @acthor yong.a.liang
 * @date 2017/12/18
 */
@Component
public class SendingBean {

    private DemoSource output;

    @Autowired
    public SendingBean(DemoSource output) {
        this.output = output;
    }

    public void sayHello(String name) {
        output.output().send(MessageBuilder.withPayload(name).build());
    }
}
