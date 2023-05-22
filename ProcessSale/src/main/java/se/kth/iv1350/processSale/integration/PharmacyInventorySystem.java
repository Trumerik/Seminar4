package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;

/**
 * The external inventory system contains all item description informations. Calls are only made 
 * to the class from the {@link Controller}
 */
public class PharmacyInventorySystem implements InventorySystem{
    private ArrayList<ItemDescriptionDTO> mockDatabase;
    
    /**
     * Creates a new instance of the {@link ExternalInventorySystem}, creating and adding item
     * descriptions to a mock database, along with its quantity in inventory.
     */
    public PharmacyInventorySystem(){
        this.mockDatabase = new ArrayList<ItemDescriptionDTO>();
        mockDatabase.add(new ItemDescriptionDTO(3.90f, "Loratadin", 0.12f));
        mockDatabase.add(new ItemDescriptionDTO(15.50f, "Plåster", 0.12f));
        mockDatabase.add(new ItemDescriptionDTO(80f, "Nässpray", 0.06f));
        mockDatabase.add(new ItemDescriptionDTO(4.95f, "Ibuprofen", 0.25f));
        mockDatabase.add(new ItemDescriptionDTO(27.95f, "Hudkräm", 0.25f));
    }

    /**
     * Method returns the item description from the mock data base, by searching for matching 
     * item identifier.
     * 
     * @param identifier the identifier of the searched item description
     * @return the specified {@link ItemDescriptionDTO}. If not found, null instead.
     * @throws ItemNotFoundException if the item identifier does not exist in the inventory system.
     * @throws DatabaseFailureException if the database could not be reached.
     */
    @Override
    public ItemDescriptionDTO getItemDescription(String identifier) throws ItemNotFoundException, DatabaseFailureException {
       if(identifier.equals("databaseFailure")) {
            throw new DatabaseFailureException("Database could not be reached");
       }
       
       for(ItemDescriptionDTO item: mockDatabase) {
            if (identifier.equals(item.getName()))
                return item;
       }
       throw new ItemNotFoundException(identifier);
    }

    /**
     * Updates the external inventory system database with the information from receipt.
     * This is not included because remote calls are not supposed to be simulated.
     * 
     * @param receipt the {@link Receipt} to be handled by inventory system
     */
    public void updateInventorySystem(Receipt receipt) {}
}