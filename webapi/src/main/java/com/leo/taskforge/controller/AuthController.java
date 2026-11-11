package com.leo.taskforge.controller;

import com.leo.taskforge.dto.request.CreateUserRequest;
import com.leo.taskforge.dto.response.UserResponse;
import com.leo.taskforge.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest user) {
        return this.authService.createUser(user);
    }
}