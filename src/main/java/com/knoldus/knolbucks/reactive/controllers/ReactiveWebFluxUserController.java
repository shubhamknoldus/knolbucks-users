package com.knoldus.knolbucks.reactive.controllers;


import com.knoldus.knolbucks.service.ReactiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReactiveWebFluxUserController {

    @Autowired
    private ReactiveUserService userService;



}
