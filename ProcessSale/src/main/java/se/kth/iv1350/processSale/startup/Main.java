package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.ReceiptPrinter;
import se.kth.iv1350.processSale.view.View; 
import se.kth.iv1350.processSale.view.TotalRevenueFileOutput;
import se.kth.iv1350.processSale.view.TotalRevenueView;

/**
 * @author Erik Hellman
 * @author Olle Gunnemyr
 * @author Edward Norberg
 *  
 *  Main is the entry point for the program and is responsible for the startup of the system.
 *  Initiliazes the receipt printer, controller and view for the sale process.
 * 
 *  @param args The command-line arguments for the program.
 */
public class Main {
    public static void main(String[] args) {
        ReceiptPrinter printer = new ReceiptPrinter();
        TotalRevenueView totalRevenueView = new TotalRevenueView();
        TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
        Controller controller = new Controller(printer, totalRevenueView, totalRevenueFileOutput);
        View view = new View(controller);
        view.systemCalls();
    }
}
