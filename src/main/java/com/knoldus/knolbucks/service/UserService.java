package com.knoldus.knolbucks.service;

import com.knoldus.knolbucks.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> getUsers();
    Mono<User> getUser(int userId);
    Mono<User> createUser(User user);

}
