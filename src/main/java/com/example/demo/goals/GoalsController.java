package com.example.demo.goals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class GoalsController {
    @Autowired
    private GoalsService goalsService;

    @RequestMapping("/goals")
    public List<Goals> getAllGoals(){
        return goalsService.getAllGoals();
    }

    @RequestMapping("/goals/{id}")
    public Goals getGoals(@PathVariable int id){
        return goalsService.getGoals(id);
    }

    @PostMapping( value = "/goals")
    public void addGoals(@RequestBody Goals goals){
        goalsService.addGoals(goals);
    }
    @PutMapping(value = "/goals/{id}")
    public void updateGoals( @PathVariable int id, @RequestBody Goals goals){
        goalsService.updateGoals(goals);
    }
    @DeleteMapping(value = "/goals/{id}")
    public void deleteGoals( @PathVariable int id){
        goalsService.deleteGoals(id);
    }

}



