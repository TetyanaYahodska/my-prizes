package com.example.demo.repository.goals;

import com.example.demo.entity.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalsRepository extends CrudRepository<Goal, Integer> {
}
