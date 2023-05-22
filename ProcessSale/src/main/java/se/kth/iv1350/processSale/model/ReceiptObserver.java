package se.kth.iv1350.processSale.model;

public interface ReceiptObserver{
    void newRevenue(float totalPrice);
}