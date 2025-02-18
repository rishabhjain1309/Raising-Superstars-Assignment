package com.example.Machine.Coding.service;


import com.example.Machine.Coding.model.Activity;
import com.example.Machine.Coding.model.User;
import com.example.Machine.Coding.model.UserActivity;
import com.example.Machine.Coding.repository.ActivityRepository;
import com.example.Machine.Coding.repository.UserActivityRepository;
import com.example.Machine.Coding.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final UserActivityRepository userActivityRepository;

    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository, UserActivityRepository userActivityRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
        this.userActivityRepository = userActivityRepository;
    }

    // Fetch activities by day
    public List<Activity> getActivitiesByDay(int day) {
        return activityRepository.findByDay(day);
    }

    // Mark an activity as completed
    public boolean markActivityComplete(Long userId, Long activityId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Activity> activity = activityRepository.findById(activityId);

        if (user.isPresent() && activity.isPresent()) {
            UserActivity userActivity = new UserActivity(null, user.get(), activity.get(), true);
            userActivityRepository.save(userActivity);
            return true;
        }
        return false;
    }

    // Fetch user progress
    public List<UserActivity> getUserProgress(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(userActivityRepository::findByUser).orElse(null);
    }
}
