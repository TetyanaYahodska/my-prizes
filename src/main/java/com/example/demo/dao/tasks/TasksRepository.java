package com.example.demo.dao.tasks;

import com.example.demo.entity.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Integer>{

}
