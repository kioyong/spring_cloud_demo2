package com.yong.gateway;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @acthor yong.a.liang
 * @date 2017/12/15
 */
public interface DemoSource {
    String DEMO_OUT = "demoOut";

    @Output(DEMO_OUT)
    MessageChannel output();

}
