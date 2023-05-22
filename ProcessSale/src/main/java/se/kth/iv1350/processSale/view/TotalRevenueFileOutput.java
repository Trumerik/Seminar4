package se.kth.iv1350.processSale.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

import se.kth.iv1350.processSale.model.ReceiptObserver;

/**
 * The class TotalRevenueFileOutput logs exceptions and prints them to a file
 */
public class TotalRevenueFileOutput implements ReceiptObserver {
    private static final String LOG_FILE_NAME = "totalRevenue-log.txt";
    private PrintWriter logFile;
    float totalRevenue = 0;

    public TotalRevenueFileOutput() {}

    @Override
    public void newRevenue(float totalPrice) {
        this.totalRevenue += totalPrice;
        logTotalRevenue(totalRevenue);
    }

    private void logTotalRevenue(float totalRevenue) {
        try {
            File outputFile = new File(LOG_FILE_NAME);
            logFile = new PrintWriter(new FileWriter(outputFile), true);
            logFile.println("\nTotal revenue: " + totalRevenue + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}