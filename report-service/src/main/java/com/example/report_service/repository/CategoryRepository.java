package com.example.report_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.report_service.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
    
}
