package com.fitness.service;

import com.fitness.model.User;
import com.fitness.repository.UserRepository;
import com.fitness.util.WorkoutRecommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private UserRepository userRepository;

    // Get full plan based on stored user data
    public String[] getWorkoutPlan(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> WorkoutRecommendations.RECOMMENDATIONS.get(value.getBodyType().toLowerCase()))
                .orElse(null);
    }

    // Infer body type based on height, weight, and goal
    public String inferBodyType(double height, double weight, String goal) {
        double ratio = weight / height;

        if (goal.equalsIgnoreCase("bulk") && ratio < 0.35){
            return "Body Type: Ectomorph";
        } else if (goal.equalsIgnoreCase("cut") && ratio > 0.45){
            return "Body Type: Endomorph";
        } else {
            return "Body Type: Mesomorph";
        }
    }
}
