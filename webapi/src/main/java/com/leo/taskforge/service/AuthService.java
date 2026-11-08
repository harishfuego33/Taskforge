package com.leo.taskforge.service;

import com.leo.taskforge.entity.Users;
import com.leo.taskforge.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    private AuthService(AuthRepository authRepository){
        this.authRepository =  authRepository;
    }
    public void createUser(Users users){
        this.authRepository.save(users);
    }



}
