package com.example.demo.service.tasks;

import com.example.demo.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITasksService {

    List<Task> getAllTasks();

    void deleteTask(int id);

    void addTask(Task tasks);

    void updateTask(Task tasks);

    ResponseEntity<Task> getTask(Integer id);
}
