package se.kth.iv1350.processSale.integration;

/**
 * This class is a factory that creates the inventory system.
 */
public class InventorySystemFactory {

    private static InventorySystemFactory factory = new InventorySystemFactory();

    /**
     * Getter for the inventory system factory.
     * 
     * @return the inventory system factory
     */
    public static InventorySystemFactory getFactory() {
        return factory;
    }

    private InventorySystemFactory() {}

    /**
     * Creates the inventory system based on the input parameter.
     * 
     * @param input The input that declares which inventory system to create.
     * @return The inventory system that was created.
     */
    public InventorySystem getInventorySystem(String input) {
        if(input.equals("Pharmacy")) {
            return new PharmacyInventorySystem();
        } 
        return new ExternalInventorySystem();
    }
}

