package com.example.demo.repository;

import com.example.demo.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer>{
}
