package com.wxx.sbw.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

    public Mono<ServerResponse> findStudentByName(ServerRequest serverRequest)
    {
        return ServerResponse.ok().body(Mono.just("Even"),String.class);
    }

}
