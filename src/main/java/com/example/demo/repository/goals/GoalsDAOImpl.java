package com.example.demo.repository.goals;

import com.example.demo.entity.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GoalsDAOImpl implements GoalsDAO{

    @Autowired
    private EntityManager entityManager;

    public GoalsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Goal theGoals) {
        entityManager.persist(theGoals);
    }

    @Override
    public Goal findById(Integer id) {
        return entityManager.find(Goal.class, id);
    }

    @Override
    public List<Goal> findAll() {
        TypedQuery<Goal> theQuery = entityManager.createQuery("FROM Goals", Goal.class);
        return theQuery.getResultList();
    }
}
