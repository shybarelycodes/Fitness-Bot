package com.fitness.controller;

import com.fitness.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping
    public Map<String, String> getFullPlan(){
        return planService.getFullPlan();
    }

    @GetMapping("/{day}")
    public String getWorkoutForDay(@PathVariable String day){
        return planService.getWorkoutForDay(day);
    }
}
