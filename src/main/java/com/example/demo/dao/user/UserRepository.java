package com.example.demo.dao.user;

import com.example.demo.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <Users, Integer>{
}
