package com.yong.mark;

import com.yong.model.Mark;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @acthor yong.a.liang
 * @date 2018/01/03
 */
@Slf4j
public class InheritableThreadLocalTest {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static List<Mark> list;

    @Test
    public void test1(){
        threadLocal.set(100);
        log.debug("before threadLocal = {}",threadLocal.get());
        log.debug("currentThread = {}",Thread.currentThread());
        Thread thread = new Thread();
        thread.start();
        log.debug("threadLocal = {}",threadLocal.get());
        log.debug("currentThread = {}",Thread.currentThread());
    }

    @Test
    public void test2(){
        initDate();
        List<Mark>sortList = list.stream().sorted(Comparator.comparing(t->t.getCreatedDate())).collect(Collectors.toList());
        log.debug("sortList = {}",getIds(sortList));

        sortList = list.stream().sorted().collect(Collectors.toList());
        log.debug("sortList = {}",getIds(sortList));

        log.debug("List = {}",list.stream().map(t -> t.getId()).collect(Collectors.toList()));

        sortList= list.stream().sorted(Comparator.comparing(Mark::getCreatedDate)).collect(Collectors.toList());
        log.debug("sortList = {}",getIds(sortList));

        sortList= list.stream().sorted(Comparator.comparing(Mark::getCreatedDate).reversed()).collect(Collectors.toList());
        log.debug("sortList = {}",getIds(sortList));
        Optional<Mark> first = sortList.stream().findFirst();
        if(first.isPresent()){
            log.debug("first = {}",first.get().getId());
        }

//        list.stream().


    }

    private List<String> getIds(List<Mark> list){
        return list.stream().map(t -> t.getId()).collect(Collectors.toList());
    }

    private void initDate(){
        Mark m1 = Mark.builder().id("1").build();
        Mark m2 = Mark.builder().id("2").build();
        Mark m3 = Mark.builder().id("3").build();
        m1.setCreatedDate(new Date());
        m2.setCreatedDate(new Date(new Date().getTime()-100000l));
        m3.setCreatedDate(new Date(new Date().getTime()+100000l));
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        log.debug("m1.date = {}",dateFormat.format(m1.getCreatedDate()));
        log.debug("m2.date = {}",dateFormat.format(m2.getCreatedDate()));
        list = Arrays.asList(m1,m2,m3);
        log.debug("mark's count = {}",list.size());
    }
}
