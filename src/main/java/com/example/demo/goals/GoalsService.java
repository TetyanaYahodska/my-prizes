package com.example.demo.goals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalsService  {
    @Autowired
    private GoalsRepository goalsRepository;

    private List<Goals> goals = new ArrayList<>();

    public List<Goals> getAllGoals(){
        goalsRepository.findAll()
                .forEach(goals::add);
        return goals;
    }

    public Goals getGoals(Integer id){
        return goalsRepository.findById(id).get();
    }

    public void addGoals(Goals goals) {
        goalsRepository.save(goals);
    }

    public void updateGoals(Goals goals) {
        goalsRepository.save(goals);
    }

    public void deleteGoals(int id) {
        goalsRepository.deleteById(id);
    }

}

