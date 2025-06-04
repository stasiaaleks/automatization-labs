package com.example;

import example.ReportGenerator;
import example.WeatherDailyReportModel;

import java.util.List;

public class ReportController {
    public List<WeatherDailyReportModel> GetAllReports(){
        // demo API controller
        ReportGenerator service = new ReportGenerator();
        return service.generateReport();
    }
}