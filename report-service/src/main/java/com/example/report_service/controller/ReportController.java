package com.example.report_service.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.report_service.dto.ReportRequest;
import com.example.report_service.dto.ReportResponse;
import com.example.report_service.model.FeedBack;
import com.example.report_service.service.ReportService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
//import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService  reportService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReport(@RequestBody ReportRequest reportRequest) {
        reportService.createReport(reportRequest);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReportResponse> getAllRsers() {
        return reportService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse getReportById(@PathVariable String id){
        return reportService.getReportById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateReportById(@PathVariable String id, @RequestBody ReportRequest reportRequest){
        reportService.updateReportById(id, reportRequest);
    }

    @PostMapping("/{reportId}/status")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateStatus(@PathVariable String reportId, @RequestBody String statusId) {
       reportService.updateStatus(reportId, statusId);
    }

    @PostMapping("/{reportId}/feedback")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeedback(@PathVariable String reportId, @RequestBody FeedBack feedBack) {
        reportService.createFeedback(reportId, feedBack);
    }

    @GetMapping("/{reportId}/feedback")
    @ResponseStatus(HttpStatus.OK)
    public FeedBack getFeedBack(@PathVariable String reportId) {
        return reportService.getFeedBack(reportId);
    }
    
    
    


}
