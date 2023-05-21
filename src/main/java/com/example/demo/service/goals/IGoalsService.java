package com.example.demo.service.goals;

import com.example.demo.entity.Goal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGoalsService {
    List<Goal> getAllGoals();

    void deleteGoal(int id);

    void addGoal(Goal goals);

    void updateGoal(Goal goals);


    ResponseEntity<Goal> getGoal(Integer id);
}
