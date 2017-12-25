package com.yong.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * @acthor yong.a.liang
 * @date 2017/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DirtiesContext
@EnableBinding({DemoSink.class})
public class StreamApplicationTests {

    @Autowired
    private DemoSink sink;

    @Test
    public void contextLoads() {
        assertNotNull(this.sink.input());
    }
}