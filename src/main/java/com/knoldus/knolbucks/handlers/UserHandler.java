package com.knoldus.knolbucks.handlers;

import com.knoldus.knolbucks.model.dbModels.Users;
import com.knoldus.knolbucks.model.requestModels.AddUser;
import com.knoldus.knolbucks.model.requestModels.UserList;
import com.knoldus.knolbucks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.
                        fromPublisher(userService.updateUserById(request.pathVariable("userId")),
                                Users.class));
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(request.bodyToMono(AddUser.class)
                                .flatMap(user -> userService.registerUser(user)), String.class
                );
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.
                        fromPublisher(userService.getUserById(request.pathVariable("userId")),
                                Users.class)
                );
    }

    public Mono<ServerResponse> getUsers(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(userService.getAllUsers(), UserList.class));
    }

}
