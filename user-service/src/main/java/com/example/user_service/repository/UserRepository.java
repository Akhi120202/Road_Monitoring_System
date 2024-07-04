package com.example.user_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.user_service.model.User;

public interface UserRepository extends MongoRepository<User, String>{
    User findByUsername(String username);

}
