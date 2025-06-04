package example;

import java.util.List;

import static example.WeatherDailyReportFactory.mockFetchDailyWeatherReports;

public class ReportGenerator {
    public List<WeatherDailyReportModel> generateReport() {
        return mockFetchDailyWeatherReports();
    }
}

