package com.example.demo.dao.tasks;

import com.example.demo.entity.Tasks;
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
    public void save(Tasks theTasks) {
        entityManager.persist(theTasks);
    }

    @Override
    public Tasks findById(Integer id) {
        return entityManager.find(Tasks.class, id);
    }

    @Override
    public List<Tasks> findAll() {
        TypedQuery<Tasks> theQuery = entityManager.createQuery("FROM Tasks", Tasks.class);
        return theQuery.getResultList();
    }
}
