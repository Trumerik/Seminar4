package se.kth.iv1350.processSale.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

import se.kth.iv1350.processSale.model.RevenueObserver;

/**
 * The class TotalRevenueFileOutput logs exceptions and prints them to a file
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private static final String LOG_FILE_NAME = "totalRevenue-log.txt";
    private PrintWriter logFile;
    float totalRevenue = 0;
    
    /**
     * Constructor for TotalRevenueFileOutput
     */
    public TotalRevenueFileOutput() {}

    /**
     * This method takes the latest totalPrice of a sale and updates the total revenue
     * of all sales which is then logged.
     * 
     * @param totalPrice The total price of the sale.
     */
    @Override
    public void showRevenue(float totalPrice) {
        this.totalRevenue += totalPrice;
        logTotalRevenue(totalRevenue);
    }

    private void logTotalRevenue(float totalRevenue) {
        try {
            File outputFile = new File(LOG_FILE_NAME);
            logFile = new PrintWriter(new FileWriter(outputFile), true);
            logFile.println("Current total revenue: " + totalRevenue + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}