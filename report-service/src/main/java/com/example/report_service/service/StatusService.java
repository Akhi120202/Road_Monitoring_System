package com.example.report_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.report_service.model.ReportStatus;
import com.example.report_service.repository.ReportStatusRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusService {

    private final ReportStatusRepository statusRepository;

    public void addStatus(ReportStatus status){
        statusRepository.save(status);
        log.info("Status {} has been added", status.getStatus());
    }

    public List<ReportStatus> getAllStatus(){
        return statusRepository.findAll();
    }
    
}
