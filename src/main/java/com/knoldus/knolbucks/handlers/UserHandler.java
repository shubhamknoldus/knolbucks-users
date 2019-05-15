package com.knoldus.knolbucks.handlers;

import com.knoldus.knolbucks.model.User;
import com.knoldus.knolbucks.service.UserService;
import org.bson.types.ObjectId;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {

	private final UserService userService;

	@Inject
	public UserHandler(UserService userService) {

		this.userService = userService;
	}

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
		final int userId = Integer.parseInt(request.pathVariable("userId"));
		final Mono<User> user = userService.getUser(userId);
		return userService.getUser(userId)
				.flatMap(p -> ok().contentType(APPLICATION_JSON).body(fromPublisher(user, User.class)))
				.switchIfEmpty(notFound().build());
	}
	
	public Mono<ServerResponse> getUsers(ServerRequest request) {
		return ok().contentType(APPLICATION_JSON)
				.body(fromPublisher(userService.getUsers(), User.class));
	}
	
}
