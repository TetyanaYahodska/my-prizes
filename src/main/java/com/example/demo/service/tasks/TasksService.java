package com.example.demo.service.tasks;

import com.example.demo.repository.tasks.TasksRepository;
import com.example.demo.entity.Task;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService implements ITasksService {

    @Autowired
    private TasksRepository tasksRepository;

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAllTasks() {
        tasksRepository.findAll()
                .forEach(tasks::add);
        return tasks;
    }

    @Override
    public ResponseEntity<Task> getTask(Integer id) {
        Task tempTasks = tasksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not exist with id: " + id));
        return ResponseEntity.ok(tempTasks);
    }

    @Override
    public void addTask(Task task) {
        tasksRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        Task tempTasks = tasksRepository.findById(task.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not exist with id: " + task.getId()));
       tempTasks.setName(task.getName());
       tempTasks.setValue(task.getValue());
        tasksRepository.save(tempTasks);
    }

    @Override
    public void deleteTask(int id) {
        tasksRepository.deleteById(id);
    }

}
