package com.example.demo.repository.goals;

import com.example.demo.entity.Goals;

import java.util.List;

public interface GoalsDAO {
    void save (Goals theGoals);
    Goals findById (Integer id);
    List<Goals> findAll();
}
