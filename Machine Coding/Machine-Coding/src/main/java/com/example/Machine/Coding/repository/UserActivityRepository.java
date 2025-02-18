package com.example.Machine.Coding.repository;

import com.example.Machine.Coding.model.UserActivity;
import com.example.Machine.Coding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    List<UserActivity> findByUser(User user);
}
