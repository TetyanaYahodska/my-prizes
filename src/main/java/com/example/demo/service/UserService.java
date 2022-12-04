package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    private List<User> users = new ArrayList<>();
    public List<User> getAllUsers(){
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public User getUsers(Integer id){
        return userRepository.findById(id).get();
    }

    public void addUsers(User users) {
        userRepository.save(users);
    }

    public void updateUsers(User users) {
        userRepository.save(users);
    }

    public void deleteUsers(int id) {
        userRepository.deleteById(id);
    }

}
