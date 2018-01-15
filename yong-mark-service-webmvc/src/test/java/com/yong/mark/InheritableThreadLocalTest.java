package com.yong.mark;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @acthor yong.a.liang
 * @date 2018/01/03
 */
@Slf4j
public class InheritableThreadLocalTest {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

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
}
