package com.example.demo.dao.goals;

import com.example.demo.entity.Goals;
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
    public void save(Goals theGoals) {
        entityManager.persist(theGoals);
    }

    @Override
    public Goals findById(Integer id) {
        return entityManager.find(Goals.class, id);
    }

    @Override
    public List<Goals> findAll() {
        TypedQuery<Goals> theQuery = entityManager.createQuery("FROM Goals", Goals.class);
        return theQuery.getResultList();
    }
}
