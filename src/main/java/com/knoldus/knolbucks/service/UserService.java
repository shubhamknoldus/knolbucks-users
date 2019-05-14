package com.knoldus.knolbucks.service;


import com.knoldus.knolbucks.model.dbModels.User;
import com.knoldus.knolbucks.model.requestModels.AddUser;
import com.knoldus.knolbucks.store.InMemoryDB;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private InMemoryDB inMemDb = new InMemoryDB();

    public User getUserById(String id){
        return inMemDb.getById(id);

    }

    public List<User> getAllUsers(){
        return inMemDb.getAll();
    }

    public String registerUser(AddUser user){
        User userToSave = createUserObject(user);
        return inMemDb.store(userToSave) ? userToSave.getId() : "User registration failed";
    }

    private User createUserObject(AddUser user){
        String uuid = java.util.UUID.randomUUID().toString();
        return new User(uuid, user.name, user.empId, user.email);
    }
}
