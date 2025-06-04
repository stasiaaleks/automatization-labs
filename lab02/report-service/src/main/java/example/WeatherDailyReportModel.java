package example;

import java.util.Date;

public record WeatherDailyReportModel(
        Date reportDate,
        double temperatureCelsius,
        double humidityPercent,
        String windDirection,
        boolean stormWarning
) {}


