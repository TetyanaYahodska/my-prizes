package com.example.demo.repository.user;

import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Users theUser) {
        entityManager.persist(theUser);
    }

    @Override
    public Users findById(Integer id) {

        return entityManager.find(Users.class, id);
    }

    @Override
    public List<Users> findAll() {
        TypedQuery<Users> theQuery = entityManager.createQuery("FROM User", Users.class);
        return theQuery.getResultList();
    }

}
