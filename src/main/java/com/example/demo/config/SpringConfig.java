package com.example.demo.config;

import com.example.demo.entity.Goals;
import com.example.demo.entity.Tasks;
import com.example.demo.entity.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class SpringConfig {

    @Bean
    public Goals getGoals() {
        return new Goals();
    }

    @Bean
    public Tasks getTasks() {
        return new Tasks();
    }

    @Bean
    public Users getUser() {
        return new Users();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
