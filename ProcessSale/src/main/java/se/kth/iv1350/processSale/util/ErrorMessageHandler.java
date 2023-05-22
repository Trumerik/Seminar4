package se.kth.iv1350.processSale.util;

import java.time.LocalDateTime;

/**
 * The class error message handler prints the error described in the message string
 */
public class ErrorMessageHandler{
    
     /**
     * Creates a new instance of the error message handler. Which is used to print the error.
     *
     */
    public ErrorMessageHandler() {}

    /**
     * Prints the error message provided as an argument.
     *
     * @param msg The message that will be shown when the exception is thrown.
     */
    public void showErrorMsg(String msg){
        System.out.println("- Returned by the errorMessageHandler -");
        System.out.println(LocalDateTime.now());
        System.out.println("- ERROR: " + msg + "\n");
    }
}