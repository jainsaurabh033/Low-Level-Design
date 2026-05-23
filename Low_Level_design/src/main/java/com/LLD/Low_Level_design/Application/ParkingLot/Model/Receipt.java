package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import java.time.LocalDateTime;

public class Receipt {
    private final String receiptId;
    private final double amount;
    private final LocalDateTime exitTime;

    public Receipt(String receiptId, double amount){
        this.receiptId = receiptId;
        this.amount = amount;
        this.exitTime = LocalDateTime.now();
    }

    public String getReceiptId(){
        return receiptId;
    }

    public double getAmount(){
        return amount;
    }

    public LocalDateTime getExitTime(){
        return exitTime;
    }

    @Override
    public String toString(){
        return "Receipt ID: " + receiptId + ", Amount: $" + amount + " , Exit Time: " + exitTime;
    }
}
