package com.yong.gateway;



import com.yong.stream.common.channel.DemoSink;
import com.yong.stream.common.channel.DemoSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableBinding({DemoSource.class,DemoSink.class})
public class StreamSendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSendApplication.class, args);
    }

    @Autowired
    private DemoSource source;

    @GetMapping("/{name}")
    public String getHelloMessage(@PathVariable(name = "name") String name) {
        source.demoOutput().send(MessageBuilder.withPayload(name).build());
        return "hello World! Send Stream successful " + name;
    }


    @StreamListener(DemoSink.DEMO_INPUT)
    private void demoIn(String name) {
        System.out.print("name = " + name);

    }
}