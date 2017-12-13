package com.yong.stream.common.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @acthor yong.a.liang
 * @date 2017/12/13
 */
public interface DemoSource {
    String DEMO_OUTPUT = "demoOutput";

    @Input(DEMO_OUTPUT)
    MessageChannel demoOutput();

}
