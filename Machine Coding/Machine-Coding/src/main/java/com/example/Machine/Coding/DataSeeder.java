package com.example.Machine.Coding;

import com.example.Machine.Coding.model.Activity;
import com.example.Machine.Coding.model.User;
import com.example.Machine.Coding.repository.ActivityRepository;
import com.example.Machine.Coding.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepo, ActivityRepository activityRepo) {
        return args -> {
            // Add Users
            User user1 = new User(null, "John Doe", "john@example.com");
            User user2 = new User(null, "Alice Smith", "alice@example.com");
            userRepo.saveAll(List.of(user1, user2));

            // Add Activities
            Activity act1 = new Activity(null, "Exercise", "Do 5 minutes of stretching", 14);
            Activity act2 = new Activity(null, "Read", "Read a motivational quote", 14);
            Activity act3 = new Activity(null, "Meditate", "Practice deep breathing", 15);
            Activity act4 = new Activity(null, "Walk", "Take a 5-minute walk", 15);
            activityRepo.saveAll(List.of(act1, act2, act3, act4));

            System.out.println("✅ Dummy Data Inserted!");
        };
    }
}

