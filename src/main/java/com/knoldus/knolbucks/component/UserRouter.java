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
	public RouterFunction<ServerResponse> routeUpdateUser(UserHandler userHandler) {

		return RouterFunctions.route(RequestPredicates.POST("/users/{userId}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)).and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), 
						userHandler::updateUser);
	}
	
	@Bean
	public RouterFunction<ServerResponse> routeCreateUser(UserHandler userHandler) {

		return RouterFunctions.route(RequestPredicates.POST("/users/").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)).and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), 
						userHandler::createUser);
	}
	
	@Bean
	public RouterFunction<ServerResponse> routeGetUser(UserHandler userHandler) {

		return RouterFunctions.route(RequestPredicates.GET("/users/{userId}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)).and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), 
						userHandler::getUser);
	}
	
	@Bean
	public RouterFunction<ServerResponse> routeGetUsers(UserHandler userHandler) {

		return RouterFunctions.route(RequestPredicates.GET("/users").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)).and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), 
						userHandler::getUsers);
	}
}