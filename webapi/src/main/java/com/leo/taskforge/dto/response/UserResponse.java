package com.leo.taskforge.dto.response;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String first_name,
        String last_name,
        String email,
        LocalDateTime created_at
) {
}
