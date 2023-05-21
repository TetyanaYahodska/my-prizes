package com.example.demo.repository.tasks;

import com.example.demo.entity.Task;

import java.util.List;

public interface TasksDAO {
    void save (Task theTasks);
    Task findById (Integer id);
    List<Task> findAll();
}
