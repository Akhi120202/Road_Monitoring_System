package com.example.authority_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authority_service.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
    Authority findByUsername(String username);

}
