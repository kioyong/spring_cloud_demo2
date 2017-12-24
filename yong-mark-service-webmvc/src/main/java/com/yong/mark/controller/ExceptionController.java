package com.yong.mark.controller;

import com.yong.model.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public Response handleArgumentException(IllegalArgumentException ex) {
        return Response.fail(ex.getMessage());
    }
}
