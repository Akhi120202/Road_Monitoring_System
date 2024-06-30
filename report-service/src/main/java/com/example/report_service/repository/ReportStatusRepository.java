package com.example.report_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.report_service.model.ReportStatus;

public interface ReportStatusRepository extends MongoRepository<ReportStatus, String>{
    
}
