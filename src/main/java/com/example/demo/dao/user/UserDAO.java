package com.example.demo.dao.user;

import com.example.demo.entity.Users;

import java.util.List;

public interface UserDAO {
    void save (Users theUser);
    Users findById (Integer id);
    List<Users> findAll();

}
