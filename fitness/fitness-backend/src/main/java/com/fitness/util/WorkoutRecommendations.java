package com.fitness.util;

import java.util.Map;

public class WorkoutRecommendations {
    public static final Map<String, String[]> RECOMMENDATIONS = Map.of(
            "ectomorph", new String[] {
                    "Focus on heavy compound lifts: Squats, Deadlifts, Bench Press. Limit cardio. Eat in a calorie surplus.",
                    "6-8 reps per set"
            },
            "mesomorph", new String[]{
                    "Balanced training: Push-pull-legs split. Mix of strength and hypertrophy. Moderate cardio.",
                    "8–12 reps per set"
            },
            "endomorph", new String[]{
                    "High-rep circuits with cardio. Combine HIIT and compound exercises. Focus on fat loss and mobility.",
                    "12–15 reps per set"
            }
    );
}
