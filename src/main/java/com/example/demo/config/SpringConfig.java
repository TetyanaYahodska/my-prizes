package com.example.demo.config;

import com.example.demo.entity.Goal;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class SpringConfig {

    @Bean
    public Goal getGoals() {
        return new Goal();
    }

    @Bean
    public Task getTasks() {
        return new Task();
    }

    @Bean
    public User getUser() {
        return new User();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
