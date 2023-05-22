package se.kth.iv1350.processSale.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * The class error message handler prints the error described in the message string
 */
public class ErrorMessageHandler{
    
    /**
     * Creates a new instance of the error message handler. Which is used to print the error.
     *
     * @param msg The message that will be shown when the exception is thrown.
     */
    public void showErrorMsg(String msg){
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(createTime());
        errorMsgBuilder.append(", ERROR: ");
        errorMsgBuilder.append(msg);
        System.out.println("- Returned by the errorMessageHandler -\n" + errorMsgBuilder + "\n");
    }

    private String createTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.
            ofLocalizedDateTime(FormatStyle.MEDIUM);

        return now.format(formatter);
    }
}