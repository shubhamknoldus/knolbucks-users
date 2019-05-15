package com.knoldus.knolbucks.service;

import com.knoldus.knolbucks.model.User;
import com.knoldus.knolbucks.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public Flux<User> getUsers(){

        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUser(int employeeId){
        return userRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Mono<User> createUser(User user){
        return userRepository.save(user);
    }
}
