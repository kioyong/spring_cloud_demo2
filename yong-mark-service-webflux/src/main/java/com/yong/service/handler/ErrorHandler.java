package com.yong.service.handler;

import com.yong.service.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;

/**
 * @acthor yong.a.liang
 * @date 2017/11/17
 */
@Slf4j
@Component
public class ErrorHandler {

    public Mono<ServerResponse> error(Throwable error) {
        log.error("error handling : {}",error.getMessage());
        return badRequest().body(Mono.just(new ErrorResponse(error.getMessage())), ErrorResponse.class);
    }
}
