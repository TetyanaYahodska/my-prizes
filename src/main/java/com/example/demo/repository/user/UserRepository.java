package com.example.demo.repository.user;

import com.example.demo.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <Users, Integer>{
}
