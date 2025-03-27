package com.fitness.controller;

import com.fitness.model.User;
import com.fitness.repository.UserRepository;
import com.fitness.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public String submitSurvey(@RequestBody User surveyUser){
        Optional<User> existingUser = userRepository.findByUsername(surveyUser.getUsername());

        if (existingUser.isEmpty()){
            return "User not found";
        }

        User user = existingUser.get();
        user.setHeight(surveyUser.getHeight());
        user.setWeight(surveyUser.getWeight());
        user.setGoal(surveyUser.getGoal());

        String bodyType = surveyService.calculateBodyType(user.getHeight(), user.getWeight());
        user.setBodyType(bodyType);

        userRepository.save(user);

        return "Survey submitted. Body Type: " + bodyType;
    }
}
