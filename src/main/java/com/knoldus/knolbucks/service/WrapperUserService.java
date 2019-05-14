package com.knoldus.knolbucks.service;

import com.knoldus.knolbucks.model.requestModels.AddUser;
import reactor.core.publisher.Mono;

public interface WrapperUserService<T, U> {
    T getUserById(String id);

    U getAllUsers();

    Mono<String> registerUser(AddUser user);

}
