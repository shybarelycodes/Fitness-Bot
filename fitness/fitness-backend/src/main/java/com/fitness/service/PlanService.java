package com.fitness.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlanService {

    private static final Map<String, String> plan = new HashMap<>();

    static {
        plan.put("monday", "Chest and Triceps");
        plan.put("tuesday", "Back and Biceps");
        plan.put("wednesday", "Leg Day");
        plan.put("thursday", "Shoulders and Abs");
        plan.put("friday", "Full Body HIIT");
        plan.put("saturday", "Active Recovery (Yoga, Walk)");
        plan.put("sunday", "Rest Day");
    }

    public Map<String, String> getFullPlan(){
        return plan;
    }

    public String getWorkoutForDay(String day){
        return plan.getOrDefault(day.toLowerCase(), "Invalid Day");
    }
}
