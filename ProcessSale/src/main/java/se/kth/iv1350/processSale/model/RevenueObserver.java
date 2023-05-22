package se.kth.iv1350.processSale.model;

public interface RevenueObserver {

    /**
     * Prints the total revenue of all sales.
     * 
     * @param totalPrice
     */
    void showRevenue(float totalPrice);
}