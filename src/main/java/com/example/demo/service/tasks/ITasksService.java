package com.example.demo.service.tasks;

import com.example.demo.entity.Tasks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITasksService {

    List<Tasks> getAllTasks();

    void deleteTask(int id);

    void addTask(Tasks tasks);

    void updateTask(Tasks tasks);

    ResponseEntity<Tasks> getTask(Integer id);
}
