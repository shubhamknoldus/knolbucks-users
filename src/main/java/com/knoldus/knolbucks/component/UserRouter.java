package com.knoldus.knolbucks.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.knoldus.knolbucks.handler.UserHandler;

import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
@Configuration
public class UserRouter {

	@Bean
	public RouterFunction<ServerResponse> routeHelloWorld(UserHandler userHandler) {

		return RouterFunctions.route(RequestPredicates.POST("/user")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), userHandler::updateUser);
	}
}