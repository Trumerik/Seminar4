package se.kth.iv1350.processSale.integration;

public class InventorySystemFactory {

    private static InventorySystemFactory factory = new InventorySystemFactory();

    public static InventorySystemFactory getFactory() {
        return factory;
    }

    private InventorySystemFactory() {}

    public InventorySystem getInventorySystem(String input) {
        if(input.equals("Pharmacy")) {
            return new PharmacyInventorySystem();
        } 
        return new ExternalInventorySystem();
    }
}

