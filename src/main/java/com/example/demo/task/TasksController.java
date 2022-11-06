package com.example.demo.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @RequestMapping("/tasks")
    public List<Tasks> getAllTask(){
        return tasksService.getAllTasks();
    }

    @RequestMapping("/tasks/{id}")
    public Tasks getTask(@PathVariable int id){
        return tasksService.getTask(id);
    }

    @PostMapping( value = "/tasks")
    public void addTask(@RequestBody Tasks task){
        tasksService.addTask(task);
    }
    @PutMapping(value = "/tasks/{id}")
    public void updateTask( @PathVariable int id, @RequestBody Tasks task){
        tasksService.updateTask(task);
    }
    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTask( @PathVariable int id){
        tasksService.deleteTask(id);
    }
}
