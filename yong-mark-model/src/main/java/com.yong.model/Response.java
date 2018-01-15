package com.yong.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @acthor yong.a.liang
 * @date 2017/11/17
 */
@Getter
@AllArgsConstructor
public class Response {

    private final String message;
    private final int code;
    private final Object playload;


    public static Response success(Object playload){
        return new Response("",0,playload);
    }

    public static Response fail(String message){
        return new Response(message,-1,null);
    }

    public static Response fail(String message,Object playload){
        return new Response(message,-1,playload);
    }

}
