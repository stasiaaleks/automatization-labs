package example;

import java.util.Date;
import java.util.List;

public class WeatherDailyReportFactory {
    public static List<WeatherDailyReportModel> mockFetchDailyWeatherReports() {
        return List.of(
                new WeatherDailyReportModel(new Date(), 21.5, 69.0, "East", false),
                new WeatherDailyReportModel(new Date(), 17.8, 84.0, "North-East", false),
                new WeatherDailyReportModel(new Date(), 14.2, 91.1, "South-West", true)
        );
    }
}
