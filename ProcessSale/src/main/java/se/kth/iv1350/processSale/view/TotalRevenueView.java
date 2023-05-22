package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.model.RevenueObserver;

/**
 * The class TotalRevenueView shows the total income of the sales on the user interface
 */
public class TotalRevenueView implements RevenueObserver{
    float totalRevenue = 0;

    /**
     * Constructor for TotalRevenueView
     */
    public TotalRevenueView() {}

    /**
     * This method takes the latest totalPrice of a sale and updates the total revenue
     * of all sales which is then printed.
     * 
     * @param totalPrice The total price of the sale.
     */
    @Override
    public void showRevenue(float totalPrice) {
        this.totalRevenue += totalPrice;
        printTotalRevenue(this.totalRevenue);
    }
    
    private void printTotalRevenue(float totalRevenue) {
        System.out.println("-Returned by the observer: Total revenue -\n" + "Total revenue: " + totalRevenue + "\n");
    }
}