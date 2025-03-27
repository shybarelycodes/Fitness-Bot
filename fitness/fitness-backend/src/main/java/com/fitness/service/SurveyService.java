package com.fitness.service;

import com.fitness.model.User;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    public String calculateBodyType(double height, double weight) {
        double bmi = weight / Math.pow(height / 100.0, 2);

        if (bmi < 18.5) return "Ectomorph";
        if (bmi < 25) return "Mesomorph";
        return "Endomorph";
    }
}
