package com.example.demo.service.user;

import java.util.List;
import com.example.demo.entity.Users;

public interface IUserService {

    List<Users> findAll();

    void deleteById(int id);

    Users save(Users user);

    Users findById(int id);

    Users updateUser(int id, Users user);

}
