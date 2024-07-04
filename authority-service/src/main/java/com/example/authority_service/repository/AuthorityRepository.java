package com.example.authority_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authority_service.model.Authority;

public interface AuthorityRepository extends MongoRepository<Authority, String>{
    Authority findByUsername(String username);

}
