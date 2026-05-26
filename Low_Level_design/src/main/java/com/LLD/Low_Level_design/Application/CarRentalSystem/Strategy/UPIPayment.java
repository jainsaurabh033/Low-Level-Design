package com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy;

public class UPIPayment implements PaymentStrategy{

    public void pay(double amount){
        System.out.println("\nPayment of " + amount + " done via UPI");
    }

}
