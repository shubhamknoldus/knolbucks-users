package com.knoldus.knolbucks.store;

import com.knoldus.knolbucks.model.dbModels.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryDB implements DB<Users> {
    static List<Users> userList = new ArrayList<Users>();


    @Override
    public Users getById(String id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public Users updateUser(String id) {
        userList = userList.stream().peek(user -> {
            if(user.getId().equalsIgnoreCase(id)){
                user.setActive(Boolean.FALSE);
            }
        }).collect(Collectors.toList());

       return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().map(users -> users.setActive(Boolean.FALSE))
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public List<Users> getAll() {
        return new ArrayList<Users>(userList);
    }

    @Override
    public boolean store(Users user) {
        return userList.add(user);
    }
}
