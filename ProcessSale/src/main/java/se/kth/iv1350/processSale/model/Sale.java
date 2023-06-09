package se.kth.iv1350.processSale.model;

import java.time.LocalDateTime;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import se.kth.iv1350.processSale.integration.DatabaseFailureException;
import se.kth.iv1350.processSale.integration.ExternalInventorySystem;
import se.kth.iv1350.processSale.integration.ItemNotFoundException;

import java.util.HashMap;

/**
 * Sale class represent the sale that is initiated by the cashier when a customer arrives 
 * at the point of sale. The sale class is responsible for keeping track of the sale and 
 * updating the receipt.
 */
public class Sale {
    private LocalDateTime timeOfSale;
    private Receipt receipt;
    private HashMap<String, ItemDescriptionDTO> seenItemsCache;
    private ExternalInventorySystem inventorySystem;
    
    /**
     * Constructor for the Sale class with the specified {@link ExternalInventorySystem} 
     * class as a parameter. Sets the time of sale, and initializes a {@link Receipt}, 
     * sets inventorySystem field and initializes the item cache. 
     * 
     * @param inventorySystem The external inventory system.
     */
    public Sale(ExternalInventorySystem inventorySystem) {
        setTimeOfSale();
        this.receipt = new Receipt(this.timeOfSale);
        this.inventorySystem = inventorySystem;
        this.seenItemsCache = new HashMap<String, ItemDescriptionDTO>();
    }

    private void setTimeOfSale() {
        this.timeOfSale = LocalDateTime.now();
    }
    
    /**
     * Retrieves the itemDescription of type {@link ItemDescriptionDTO} based on the given identifier and 
     * returns the currentSaleStatus of type {@link CurrentSaleStatusDTO} that contains the itemDescription
     * and the running total.
    
     * @param identifier is the identifier of the scanned item. 
     * @return The currentSaleStatus that contains the itemDescription of the item and the runningTotal 
     * of the sale.
     * @throws ItemNotFoundException if the item identifier does not exist in the inventory system.
     * @throws DatabaseFailureException if the database could not be reached.
     */
    public CurrentSaleStatusDTO requestSaleInformation(String identifier) throws ItemNotFoundException, DatabaseFailureException {
        ItemDescriptionDTO itemDescription = getItemDescription(identifier);
        CurrentSaleStatusDTO currentSaleStatus = new CurrentSaleStatusDTO(itemDescription, receipt.getTotalPrice());

        return currentSaleStatus;
    }

    private ItemDescriptionDTO getItemDescription(String identifier) throws ItemNotFoundException, DatabaseFailureException {
        ItemDescriptionDTO itemDescription = retrieveFromCache(identifier);
        if (itemDescription == null) {
            //Exception 
            itemDescription = inventorySystem.getItemDescription(identifier);
            addItemToCache(identifier, itemDescription);
        }
        receipt.addItemToReceipt(itemDescription);
        return itemDescription;
    }
    
    private ItemDescriptionDTO retrieveFromCache(String identifier) {
        if (seenItemsCache.containsKey(identifier)) {
            return seenItemsCache.get(identifier);
        }
        return null;
    }
    
    private void addItemToCache(String identifier, ItemDescriptionDTO itemDescription) {
        seenItemsCache.put(identifier, itemDescription);
    }

    /**
     * Updates the {@link Receipt} with the recieved payment.
     * 
     * @param payment is the payment provided. 
     */
    public void updateReceiptWithPayment(float payment) {
        receipt.updateReceiptWithPayment(payment);
    }

    /**
     * Retrieves the {@link Receipt} from the Sale.
     * 
     * @return The receipt of the Sale instance. 
     */
    public Receipt getReceipt() {
        return this.receipt;
    }
}
