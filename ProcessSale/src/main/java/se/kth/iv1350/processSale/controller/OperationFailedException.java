package se.kth.iv1350.processSale.controller;
/**
 *  This exception is thrown when an operation fails.
 *  
 *  @param message The message that will be shown when the exception is thrown.
 *  @param cause The cause for the exception
 */
public class OperationFailedException extends Exception {
    public OperationFailedException(String message, Exception cause) {
        super(message, cause);
    }
}