package com.yong.mark;

import com.yong.model.Mark;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;

/**
 * @acthor yong.a.liang
 * @date 2018/01/22
 */
@Slf4j
public class StreamTest {

    @Test
    public void test1() {
        Mark mark1 = new Mark();
        mark1.setId("1");
        mark1.setActivity(true);
        mark1.setTitle("test");
        Mark mark = new Mark();
        mark.setId("2");
        mark.setActivity(false);
        mark.setTitle(null);
        Mark mark3 = null;
        String s;
        List<Mark> marks = Arrays.asList(mark1, mark,mark3);
//        s = marks.stream().filter(m -> m.isActivity() == false)
//            .findFirst().map(Mark::getTitle).orElse("");

//        Optional<Mark> first = marks.stream().filter(Mark::isActivity).findFirst();
//        assertFalse(first.isPresent());

//        Optional<String> s1 = marks.stream().filter(m -> !m.isActivity()).findFirst().map(Mark::getTitle);
//        assertFalse(s1.isPresent());

        s = marks.stream().filter(m -> m.isActivity()).findFirst().map(Mark::getTitle).orElse("nullPointExx");
        assertEquals(s, "test");


    }

    @Test
    public void test2() {

        Mark mark1 = new Mark();
        mark1.setId("1");
        mark1.setActivity(false);
        mark1.setTitle("test");
        Mark mark = new Mark();
        mark.setId("2");
        mark.setActivity(false);
        mark.setTitle(null);
        List<Mark> marks = Arrays.asList(mark1, mark);
        String s;
//        s = marks.stream().filter(Mark::isActivity).findFirst().map(Mark::getTitle).orElse("nullPointExx");
//        assertEquals(s,"test");
//        mark1.setTitle(null);
//        s = marks.stream().filter(Mark::isActivity).findFirst().map(Mark::getTitle).orElse("nullPointExx");
//        assertEquals(s,"nullPointExx");
//        mark1.setActivity(false);

//        Optional<Mark> first = marks.stream().filter(Mark::isActivity).findFirst();
//        assertFalse(first.isPresent());
//
//        Optional<String> s1 = marks.stream().filter(Mark::isActivity).findFirst().map(Mark::getTitle);
//        assertFalse(s1.isPresent());

        s = marks.stream().filter(Mark::isActivity).findFirst().map(Mark::getTitle).orElse("nullPointExx");
        assertEquals(s, "nullPointExx");
    }
}

