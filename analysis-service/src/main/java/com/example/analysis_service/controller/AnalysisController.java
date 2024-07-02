package com.example.analysis_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.analysis_service.model.Report;
import com.example.analysis_service.service.AnalysisService;
import com.example.analysis_service.service.ReportService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/total-reports")
    public long getTotalReports() {
        List<Report> reports = reportService.fetchAllReports();
        return analysisService.getTotalReports(reports);
    }

    @GetMapping("/reports-by-status")
    public Map<String, Long> getReportsByStatus() {
        List<Report> reports = reportService.fetchAllReports();
        return analysisService.getReportsByStatus(reports);
    }

    @GetMapping("/reports-by-category")
    public Map<String, Long> getReportsByCategory() {
        List<Report> reports = reportService.fetchAllReports();
        return analysisService.getReportsByCategory(reports);
    }
}
