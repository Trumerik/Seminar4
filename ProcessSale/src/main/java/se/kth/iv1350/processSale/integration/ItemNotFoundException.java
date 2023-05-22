package se.kth.iv1350.processSale.integration;
/**
 *  This exception is thrown when an item is not found.
 */
public class ItemNotFoundException extends Exception{
    private String identifierNotFound;
    
    /**
     * Creates a new instance of the exception with the specified message and cause.
     * 
     * @param identifier The identifier that was not found.
     */
    public ItemNotFoundException(String identifier) {
        super("Unable to find the identifier: " + identifier + " in the inventory system.");
        this.identifierNotFound = identifier;
    }
    
    /**
     * Returns the identifier that was not found.
     * 
     * @return The identifier that was not found.
     */
    public String getIdentifierNotFound(){
        return this.identifierNotFound;
    }
}   