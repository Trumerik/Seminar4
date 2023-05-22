package se.kth.iv1350.processSale.integration;

/**
 *  This exception is thrown when the connection to the database fails.
 */
public class DatabaseFailureException extends Exception {
    
    /**
     * Constructor for the exception
     * @param message The message that will be shown when the exception is thrown.
     */
    public DatabaseFailureException(String message) {
        super(message);
    }
}