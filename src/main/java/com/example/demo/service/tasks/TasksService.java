package com.example.demo.service.tasks;

import com.example.demo.repository.tasks.TasksRepository;
import com.example.demo.entity.Tasks;
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

    private List<Tasks> tasks = new ArrayList<>();

    @Override
    public List<Tasks> getAllTasks() {
        tasksRepository.findAll()
                .forEach(tasks::add);
        return tasks;
    }

    @Override
    public ResponseEntity<Tasks> getTask(Integer id) {
        Tasks tempTasks = tasksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not exist with id: " + id));
        return ResponseEntity.ok(tempTasks);
    }

    @Override
    public void addTask(Tasks task) {
        tasksRepository.save(task);
    }

    @Override
    public void updateTask(Tasks task) {
        Tasks tempTasks = tasksRepository.findById(task.getId())
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
