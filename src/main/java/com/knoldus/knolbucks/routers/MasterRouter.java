package com.knoldus.knolbucks.routers;

import com.knoldus.knolbucks.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MasterRouter {

    @Bean
    public RouterFunction<ServerResponse> masterRoutes(UserRouter userRouter, UserHandler userHandler) {
        return RouterFunctions.route()
                .add(userRouter.userRoutes(userHandler))
                .build();
    }
}
