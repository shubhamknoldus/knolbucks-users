package com.knoldus.knolbucks.routes;


import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public class Routes {
    RouterFunction<ServerResponse> route = route().add(otherRoute)
            .build();
}
