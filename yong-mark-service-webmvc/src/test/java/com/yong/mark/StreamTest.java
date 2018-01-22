package com.yong.mark;

import com.yong.model.Item;
import com.yong.model.Mark;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @acthor yong.a.liang
 * @date 2018/01/22
 */
@Slf4j
public class StreamTest {

    @Test
    public void test1(){
        Mark mark1 = new Mark();
        mark1.setId("1");
        mark1.setActivity(true);
        mark1.setTitle("test");
        Mark mark = new Mark();
        mark.setId("2");
        mark.setActivity(false);
        mark.setTitle(null);

        List<Mark> marks = Arrays.asList(mark1,mark);
        String s = marks.stream().filter(m -> m.isActivity() == false)
            .map(m -> m.getTitle()).findFirst().orElse("123");
        marks.stream().filter(m -> m.isActivity() == false)
            .map(m -> m.getTitle()).findFirst().orElse("123").;
        log.debug("s = {}",s);

    }
}

