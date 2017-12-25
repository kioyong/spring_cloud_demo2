package com.yong.gateway;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @acthor yong.a.liang
 * @date 2017/12/15
 */
public interface DemoSink {
    String DEMO_INPUT = "demoIn";

    @Input(DEMO_INPUT)
    SubscribableChannel input();
}