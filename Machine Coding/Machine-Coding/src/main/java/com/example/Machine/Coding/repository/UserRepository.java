package com.example.Machine.Coding.repository;

import com.example.Machine.Coding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
