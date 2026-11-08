package com.leo.taskforge.controller;

import com.leo.taskforge.entity.Users;
import com.leo.taskforge.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
class AuthController{
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping
    public void createUser(@RequestBody Users users){
        this.authService.createUser(users);
    }
}