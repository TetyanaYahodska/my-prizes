package com.example.demo.repository.tasks;

import com.example.demo.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Integer>{

}
