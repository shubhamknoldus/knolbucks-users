package com.knoldus.knolbucks.handlers;

import com.knoldus.knolbucks.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

	private UserService userService;

	public Mono<ServerResponse> updateUser(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Update USer"));
	}
	
	public Mono<ServerResponse> createUser(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject(userService.registerUser(request.body())));
	}
	
	public Mono<ServerResponse> getUser(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject(userService.getUserById(request.pathVariable("userId"))));
	}
	
	public Mono<ServerResponse> getUsers(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject(userService.getAllUsers()));
	}
	
}
