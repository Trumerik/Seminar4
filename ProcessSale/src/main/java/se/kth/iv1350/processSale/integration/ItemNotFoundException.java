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
        super("Item \"" + identifier + "\" was not found, verify identifier and try again.");
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