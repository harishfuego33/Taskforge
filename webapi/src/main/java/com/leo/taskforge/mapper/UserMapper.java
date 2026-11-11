package com.leo.taskforge.mapper;

import com.leo.taskforge.dto.request.CreateUserRequest;
import com.leo.taskforge.dto.response.UserResponse;
import com.leo.taskforge.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(Users user) {
        return new UserResponse(
                user.getId(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getCreated_at());
    }

    public Users toEntity(CreateUserRequest request) {
        Users user = new Users();
        user.setFirst_name(request.first_name());
        user.setLast_name(request.last_name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        return user;
    }

}