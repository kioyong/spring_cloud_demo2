package com.yong.service.handler;

import com.yong.model.Mark;
import com.yong.service.repository.MarkRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */
@Slf4j
@Component
@AllArgsConstructor
public class MarkHandler {

    private final MarkRepository repository;
    private final ErrorHandler errorHandler;
//    private final MarkService markService;

    public Mono<ServerResponse> findOneMark(final ServerRequest request) {
        return repository.findById(request.pathVariable("id"))
            .transform(this::serverResponse);
    }

    public Mono<ServerResponse> findAllMark(final ServerRequest request) {
//        return ok().body(repository.findAll(new Sort(Sort.Direction.ASC, "id"))
//                /*.take(3)*/,Mark.class);
        return ok().body(repository.findAllActivityItems(),Mark.class);
    }

    public Mono<ServerResponse> addMark(final ServerRequest request) {
        return request.bodyToMono(Mark.class)
            .flatMap(repository::insert)
            .transform(this::serverResponse)
            .onErrorResume(errorHandler::error);
    }


    public Mono<ServerResponse> updateMark(final ServerRequest request) {

        return request.bodyToMono(Mark.class).flatMap(t ->
            repository.findById(t.getId())
                .switchIfEmpty(
                    Mono.error(new IllegalArgumentException("not found mark in DB, update failure."))
                )
                .flatMap(o ->  repository.save(Mark.updateMark(o,t))))
        .transform(this::serverResponse)
        .onErrorResume(errorHandler::error);
    }

    Mono<ServerResponse> serverResponse(Mono<Mark> markMono) {
        return ok().body(markMono, Mark.class);
    }

    public Mono<ServerResponse> helloWorld(final ServerRequest request) {
//        return ok().body(Mono.just("helloWorld -> 9001"), String.class);
        return ok().body(Mono.just("helloWorld -> 9001"), String.class);
    }


    public Mono<ServerResponse> optionsRequest(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON).build();
    }

}
