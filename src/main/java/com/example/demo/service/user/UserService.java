package com.example.demo.service.user;

import com.example.demo.dao.user.UserRepository;
import com.example.demo.entity.Users;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    private List<Users> users = new ArrayList<>();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAll() {
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    @Override
    public Users findById(int id) {
        Optional<Users> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }else {
                throw  new ResourceNotFoundException("User not exist with id: " + id);
        }
    }

    @Override
    public Users updateUser(int id, Users user) {
        Users tempUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        tempUser.setPassword(user.getPassword());
        tempUser.setEmail(user.getEmail());
        tempUser.setFirstName(user.getFirstName());
        tempUser.setLastName(user.getLastName());
       return  userRepository.save(tempUser);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users save(Users theUser) {
        return userRepository.save(theUser);
    }

}
