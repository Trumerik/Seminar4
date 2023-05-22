package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;

public interface InventorySystem {

    ItemDescriptionDTO getItemDescription(String identifier) throws ItemNotFoundException, DatabaseFailureException;

    void updateInventorySystem(Receipt receipt);
}
