package com.example.Machine.Coding.repository;

import com.example.Machine.Coding.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByDay(int day);
}
