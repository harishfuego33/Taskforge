package com.leo.taskforge.service;

import com.leo.taskforge.dto.request.CreateUserRequest;
import com.leo.taskforge.dto.response.UserResponse;
import com.leo.taskforge.entity.Users;
import com.leo.taskforge.mapper.UserMapper;
import com.leo.taskforge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private AuthService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(CreateUserRequest request) {
        if(userRepository.exitsByEmail(request.email())){
            throw new IllegalArgumentException("Email is already exist");
        }
        Users user = userMapper.toEntity(request);
        Users savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
