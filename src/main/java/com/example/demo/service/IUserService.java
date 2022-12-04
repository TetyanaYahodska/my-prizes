package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;


import com.example.demo.dto.UserDto;
import com.example.demo.user.User;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    User findUserByEmail(String email);


    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);


}
