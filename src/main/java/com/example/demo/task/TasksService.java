package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    private List<Tasks> tasks = new ArrayList<>();

    public List<Tasks> getAllTasks(){
        tasksRepository.findAll()
                .forEach(tasks::add);
        return tasks;
    }

    public Tasks getTask(Integer id){
        return tasksRepository.findById(id).get();
        }

    public void addTask(Tasks task) {
        tasksRepository.save(task);
    }

    public void updateTask(Tasks task) {
        tasksRepository.save(task);
    }

    public void deleteTask(int id) {
        tasksRepository.deleteById(id);
    }
}
