package com.yong.location;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Doudizhu {

    public List<Integer> d;
    public List<Integer> n;

    @Test
    public void demo1(){
        d = Arrays.asList(4,5);
        n = Arrays.asList(3,5);



    }

    public List<Integer> OutOne(List<Integer> d,int i){
        Integer out = d.stream().filter(t -> t>i).sorted().findFirst().get();
        List<Integer> result = d.stream().filter(t -> t != out).collect(Collectors.toList());
        return result;
    }


}
