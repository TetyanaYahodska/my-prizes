package com.example.demo.service.goals;

import com.example.demo.entity.Goals;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGoalsService {
    List<Goals> getAllGoals();

    void deleteGoal(int id);

    void addGoal(Goals goals);

    void updateGoal(Goals goals);


    ResponseEntity<Goals> getGoal(Integer id);
}
