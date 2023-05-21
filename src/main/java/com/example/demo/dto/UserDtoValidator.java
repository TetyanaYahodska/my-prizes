package com.example.demo.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> arg0) {
        return UserDto.class.equals(arg0);
    }

    @Override
    public void validate(Object user, Errors errors) {
        UserDto userDto = (UserDto) user;
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            errors.rejectValue("repeatPassword", "PasswordsDontMatch");
        }
    }
}
