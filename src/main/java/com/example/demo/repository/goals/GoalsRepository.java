package com.example.demo.repository.goals;

import com.example.demo.entity.Goals;
import org.springframework.data.repository.CrudRepository;

public interface GoalsRepository extends CrudRepository<Goals, Integer> {
}
