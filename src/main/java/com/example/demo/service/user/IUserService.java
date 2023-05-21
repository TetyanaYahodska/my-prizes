package com.example.demo.service.user;

import java.util.List;
import com.example.demo.entity.User;

public interface IUserService {

    List<User> findAll();

    void deleteById(int id);

    User save(User user);

    User findById(int id);

    User updateUser(int id, User user);

}
