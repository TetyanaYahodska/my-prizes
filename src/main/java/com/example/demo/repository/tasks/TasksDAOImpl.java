package com.example.demo.repository.tasks;

import com.example.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TasksDAOImpl implements TasksDAO {
    @Autowired
    private EntityManager entityManager;

    public TasksDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Task theTasks) {
        entityManager.persist(theTasks);
    }

    @Override
    public Task findById(Integer id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task> theQuery = entityManager.createQuery("FROM Tasks", Task.class);
        return theQuery.getResultList();
    }
}
