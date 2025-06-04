package com.example;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var reports = new ReportController().GetAllReports();
        logger.info("Got " + reports.size() + " reports.");
    }

}
