package com.leo.taskforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.taskforge.entity.Users;


public interface AuthRepository extends JpaRepository<Users, Long> {
    boolean exitsByEmail(String email);
}