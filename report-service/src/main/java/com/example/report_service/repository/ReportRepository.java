package com.example.report_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.report_service.model.Report;

public interface ReportRepository extends MongoRepository<Report, String>{
    
}
