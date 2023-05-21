package com.example.demo.repository.goals;

import com.example.demo.entity.Goal;

import java.util.List;

public interface GoalsDAO {
    void save (Goal theGoals);
    Goal findById (Integer id);
    List<Goal> findAll();
}
