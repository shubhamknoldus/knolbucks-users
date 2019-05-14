package com.knoldus.knolbucks.service;

import com.knoldus.knolbucks.model.dbModels.User;
import com.knoldus.knolbucks.model.requestModels.AddUser;
import com.knoldus.knolbucks.store.InMemoryDB;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class ReactiveUserService implements WrapperUserService{

    private InMemoryDB inMemDb = new InMemoryDB();

    public Mono<User> getUserById(String id){
        return Mono.just(inMemDb.getById(id));

    }

    public Flux<List<User>> getAllUsers(){
        return Flux.just(inMemDb.getAll());
    }

    public Mono<String> registerUser(AddUser user){
        User userToSave = createUserObject(user);
        return Mono.just(inMemDb.store(userToSave) ? userToSave.getId() : "User registration failed");
    }

    private User createUserObject(AddUser user){
        String uuid = java.util.UUID.randomUUID().toString();
        return new User(uuid, user.name, user.empId, user.email);
    }
}
