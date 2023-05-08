package com.example.demo.repository.tasks;

import com.example.demo.entity.Tasks;

import java.util.List;

public interface TasksDAO {
    void save (Tasks theTasks);
    Tasks findById (Integer id);
    List<Tasks> findAll();
}
