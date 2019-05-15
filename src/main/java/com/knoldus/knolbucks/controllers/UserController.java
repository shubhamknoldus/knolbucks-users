package com.knoldus.knolbucks.controllers;

import com.knoldus.knolbucks.model.dbModels.User;
import com.knoldus.knolbucks.model.requestModels.AddUser;
import com.knoldus.knolbucks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/users")
@RestController
public class UserController {

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }


    @PostMapping
    public String registerUser(@RequestBody AddUser user) {
        return userService.registerUser(user);

    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
