package se.kth.iv1350.processSale.integration;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;

/**
 * Here we perform tests the {@link ExternalInventorySystem} class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class ExternalInventorySystemTest {
    ExternalInventorySystem inventorySystem;
    
    /**
     * A set up method to be performed before the tests
     */
    @Before
    public void setUp() {
        this.inventorySystem = new ExternalInventorySystem();
    }
    
    /**
     * Test on the method getItemDescription to correctly find an existing {@link itemDescriptioDTO} with the
     * matching identifier
     */
    @Test
    public void testGetItemDescriptionExists() throws ItemNotFoundException, DatabaseFailureException {
        ItemDescriptionDTO itemDescription = inventorySystem.getItemDescription("mjöl");
        assert(itemDescription.getName().equals("mjöl"));
    }
    
    /**
     * Test on the exception DatabaseFailureException to throw and catch an exception if the database is unavailable
     */
    @Test(expected = DatabaseFailureException.class)
    public void testDatabaseFailureException() throws ItemNotFoundException, DatabaseFailureException {
        ItemDescriptionDTO itemDescription = inventorySystem.getItemDescription("databaseFailure");
        assertEquals(itemDescription, null);
    }

    /**
     * Test on the exception testItemNotFoundException to throw and catch an exception if the item is not found
     */
    @Test(expected = ItemNotFoundException.class)
    public void testItemNotFoundException() throws ItemNotFoundException, DatabaseFailureException {
        ItemDescriptionDTO itemDescription = inventorySystem.getItemDescription("Invalid");
        assertEquals(itemDescription, null);
    }
}