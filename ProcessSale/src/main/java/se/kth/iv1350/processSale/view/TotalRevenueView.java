package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.model.ReceiptObserver;

class TotalRevenueView implements ReceiptObserver{
    float totalRevenue = 0;

    public void TotalRevenueFileOutput () {}

    @Override
    public void newRevenue(float totalPrice) {
        this.totalRevenue += totalPrice;
        printTotalRevenue(totalRevenue);
    }
    
    private void printTotalRevenue(float totalRevenue) {
        System.out.println("\nTotal revenue: " + totalRevenue + "Olle Gunnemyr THE KING yooom8!\n");
    }
} 