package com.example.demo.rest;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @RequestMapping("/users/{usersId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        User user = userService.findById(id);

        UserDto userResponce = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok().body(userResponce);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        User userRequest = modelMapper.map(userDto, User.class);
        User user = userService.save(userRequest);
        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        User userRequest = modelMapper.map(userDto, User.class);
        User user = userService.updateUser(id, userRequest);
        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/users/{usersId}")
    public String deleteUser(@PathVariable int userId) {
        User tempUser = userService.findById(userId);
        if(tempUser == null) {
            throw new RuntimeException("User id not found - " +userId);
        }

        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }

}











