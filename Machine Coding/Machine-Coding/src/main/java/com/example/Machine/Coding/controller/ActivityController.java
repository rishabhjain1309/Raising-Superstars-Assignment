package com.example.Machine.Coding.controller;

import com.example.Machine.Coding.model.Activity;
import com.example.Machine.Coding.model.UserActivity;
import com.example.Machine.Coding.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // API to fetch activities for a given day
    @GetMapping
    public ResponseEntity<List<Activity>> getActivities(@RequestParam int day) {
        return ResponseEntity.ok(activityService.getActivitiesByDay(day));
    }

    // API to mark an activity as completed
    @PostMapping("/mark-complete")
    public ResponseEntity<String> markActivityComplete(@RequestBody Map<String, Long> request) {
        boolean success = activityService.markActivityComplete(request.get("userId"), request.get("activityId"));
        return success ? ResponseEntity.ok("Activity marked as complete")
                : ResponseEntity.badRequest().body("Invalid user or activity ID");
    }

    // API to get user progress
    @GetMapping("/progress/{userId}")
    public ResponseEntity<List<UserActivity>> getUserProgress(@PathVariable Long userId) {
        return ResponseEntity.ok(activityService.getUserProgress(userId));
    }
}
