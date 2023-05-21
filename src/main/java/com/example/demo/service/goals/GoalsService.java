package com.example.demo.service.goals;

import com.example.demo.repository.goals.GoalsRepository;
import com.example.demo.entity.Goal;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalsService implements IGoalsService {

    @Autowired
    private GoalsRepository goalsRepository;

    private final List<Goal> goals = new ArrayList<>();
    @Override
    public List<Goal> getAllGoals() {
        goalsRepository.findAll()
                .forEach(goals::add);
        return goals;
    }

    @Override
    public void deleteGoal(int id) {
        goalsRepository.deleteById(id);
    }

    @Override
    public void addGoal(Goal goals) {
        goalsRepository.save(goals);
    }

    @Override
    public void updateGoal(Goal goals) {
        Goal tempGoals = goalsRepository.findById(goals.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Goal not exist with id: " + goals.getId()));
        tempGoals.setName(goals.getName());
        tempGoals.setValue(goals.getValue());

        goalsRepository.save(tempGoals);
    }

    @Override
    public ResponseEntity<Goal> getGoal(Integer id) {
        Goal tempGoals = goalsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not exist with id: " + id));
        return ResponseEntity.ok(tempGoals);
    }
}
