package com.knoldus.knolbucks.service;


import com.knoldus.knolbucks.model.dbModels.Users;
import com.knoldus.knolbucks.model.requestModels.AddUser;
import com.knoldus.knolbucks.model.requestModels.UserList;
import com.knoldus.knolbucks.store.InMemoryDB;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    private InMemoryDB inMemDb = new InMemoryDB();

    public Mono<Users> getUserById(String id){
        return Mono.just(inMemDb.getById(id));
    }


    public Mono<Users> updateUserById(String id){
        return Mono.just(inMemDb.getById(id));
    }

    public Flux<UserList> getAllUsers(){
        return Flux.just(new UserList(inMemDb.getAll()));
    }

    public Mono<String> registerUser(AddUser user){
        Users userToSave = createUserObject(user);
        return Mono.just(inMemDb.store(userToSave) ? userToSave.getId() : "User registration failed");
    }


    private Users createUserObject(AddUser user){
        String uuid = java.util.UUID.randomUUID().toString();
        return new Users(uuid, user.empId, user.name, user.email, user.dateOfBirth, user.role);
    }
}
