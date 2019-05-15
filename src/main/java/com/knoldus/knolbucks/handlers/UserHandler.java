package com.knoldus.knolbucks.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

	public Mono<ServerResponse> updateUser(ServerRequest request) {
		String userId = request.pathVariable("userId");
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("userId"+userId));
	}
	
	public Mono<ServerResponse> createUser(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Create USer"));
	}
	
	public Mono<ServerResponse> getUser(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Get USer"));
	}
	
	public Mono<ServerResponse> getUsers(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Get USers"));
	}
	
}
