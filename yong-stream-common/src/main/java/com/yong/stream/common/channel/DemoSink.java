package com.yong.stream.common.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @acthor yong.a.liang
 * @date 2017/12/13
 */
public interface DemoSink {
    String DEMO_INPUT = "demoIntput";

    @Input(DEMO_INPUT)
    SubscribableChannel demoIntput();
}
