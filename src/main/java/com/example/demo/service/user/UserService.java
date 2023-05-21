package com.example.demo.service.user;

import com.example.demo.repository.user.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final List<User> users = new ArrayList<>();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }else {
                throw  new ResourceNotFoundException("User not exist with id: " + id);
        }
    }

    @Override
    public User updateUser(int id, User user) {
        User tempUser = userRepository.findById(id)
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
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

}
