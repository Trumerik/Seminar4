package se.kth.iv1350.processSale.view;

import java.io.IOException;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.ItemNotFoundException;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.util.ErrorMessageHandler;
import se.kth.iv1350.processSale.util.PrettyPrinter;
import se.kth.iv1350.processSale.util.LogHandler;

/**
 * View class represents the interface between the cashier and the system.
 * This class contains the hardcoded system calls that represent the basic
 * flow (and the one alternate flow required) described in the seminar instructions. 
 */
public class View {
    private static final String SELECTED_ITEMS_TYPE = "Pharmacy";
    private Controller controller;
    private PrettyPrinter prettyPrinter;
    private ErrorMessageHandler errorMessageHandler;
    private LogHandler logger;
    
    /**
     * Constructor for the View class with the specified {@link Controller} class as a parameter.
     * 
     * @param controller is an instance of the Controller.
     */
    public View(Controller controller) {
        this.controller = controller;
        this.prettyPrinter = new PrettyPrinter();
        this.errorMessageHandler = new ErrorMessageHandler();
        try {
            this.logger = new LogHandler();
        } catch (IOException e) {
            writeToLogAndUI("Failed to connect with log system", e);
        }
    }

    /**
     * This method contains the hardcoded system calls that represent the user interface, 
     * we showcase basic flow, and the one alternate flow, as described in the task instructions.
     * We also have printouts directly the System.out when the something is returned by the controller.
     * 
     * Here is an explination of the mock user interface system calls:
     * 1. Cashier starts the sale and adds revenue observers.
     * 2. Cashier enters the item identifier "databaseFailure" and the system returns error message.
     * 3. Cashier enters the item identifier "mandarin" and the system returns the current sale status.
     * 4. Cashier enters the item identifier "honung" and the system returns the current sale status.
     * 5. Cashier ends the sale.
     * 6. Cashier enters the amount paid by the customer and finally the receipt is printed.
     * 7. Cashier starts second sale
     * 8. Cashier enters the item identifier "mjöl" and the system returns the current sale status.
     * 9. Cashier enters the item identifier "mandarin" and the system returns the current sale status.
     * 10. Cashier ends the sale.
     * 11. Cashier enters the amount paid by the customer and finally the receipt is printed.
     */
    public void systemCalls() {
        this.controller.setInventorySystem(SELECTED_ITEMS_TYPE);
        this.controller.startSale();
        
        String identifier;
        CurrentSaleStatusDTO currentSaleStatus;
        
        try{
            identifier = "Loratadin";
            currentSaleStatus = this.controller.entersItemIdentifier(identifier);
            this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);
        
            identifier = "Loratadin";
            currentSaleStatus = this.controller.entersItemIdentifier(identifier);
            this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

            identifier = "Plåster";
            currentSaleStatus = this.controller.entersItemIdentifier(identifier);
            this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);


            float totalPrice = this.controller.endSale();
            this.prettyPrinter.printTotalPrice(totalPrice);
            
            float payment = 200f;
            float change = this.controller.entersPayment(payment);
            this.prettyPrinter.printChange(change);

            this.controller.printReceipt();
        } catch (ItemNotFoundException e) {
            this.errorMessageHandler.showErrorMsg(e.getMessage());
        } catch (Exception e){
            writeToLogAndUI("Failed to add item", e);
        }
    }

    private void writeToLogAndUI(String uiMsg, Exception e){
        errorMessageHandler.showErrorMsg(uiMsg);
        logger.logException(e);
    }
}