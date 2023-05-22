package se.kth.iv1350.processSale.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * The class LogHandler logs exceptions and prints them to a file
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "processSale-log.txt";
    private PrintWriter logFile;

    /**
     * Creates a new instance of the log handler. Which is used to print the log.
     * 
     * @throws IOException if the log file cannot be created.
     */
    public LogHandler() throws IOException{
        File outputFile = new File(LOG_FILE_NAME);
        logFile = new PrintWriter(new FileWriter(outputFile), true);
    }

    /**
     * Prints the log message to the log file.
     * 
     * @param exception The exception that will be logged.
     */
    public void logException(Exception exception){
        logFile.println(LocalDateTime.now());
        logFile.println("- Exception thrown: " + exception.getMessage());
        exception.printStackTrace(logFile);
    }
}