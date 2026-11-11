package com.leo.taskforge.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "First name is required")
        @Size(min=3,max=25,message="First name mush be between 3 and 25 characters")
        String first_name,

        @NotBlank(message = "Last name is required")
        @Size(min=3,max=25,message="Last name must be between 3 and 25 characters")
        String last_name,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email formate")
        String email,

        @NotBlank(message = "Password is required")
        @Size(max = 8,message = "Password must be 8 characters")
        String password
) {}