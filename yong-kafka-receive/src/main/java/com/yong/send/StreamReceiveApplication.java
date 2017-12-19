package com.yong.send;

import com.yong.stream.common.channel.DemoSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@SpringBootApplication
@EnableBinding(DemoSink.class)
public class StreamReceiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamReceiveApplication.class, args);
    }


    @StreamListener(DemoSink.DEMO_INPUT)
    private void demoIn(String name) {
        System.out.print("name = " + name);

    }

}

