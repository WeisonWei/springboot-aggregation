package com.wxx.sbw.router;

import com.wxx.sbw.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StudentRouter {
    private final static String BASE_PATH = "/names";

    @Bean
    public RouterFunction<ServerResponse> userRoutersFunctionMock(StudentHandler studentHandler) {
        RouterFunction<ServerResponse> serverResponse = route()
                .GET(BASE_PATH + "/{name}", accept(APPLICATION_JSON), studentHandler::findStudentByName)
                .build();
        return serverResponse;
    }
}
