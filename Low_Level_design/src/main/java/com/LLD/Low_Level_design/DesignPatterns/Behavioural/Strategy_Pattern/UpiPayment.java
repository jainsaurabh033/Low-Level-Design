package com.LLD.Low_Level_design.DesignPatterns.Behavioural.Strategy_Pattern;

public class UpiPayment implements PaymentStrategy{

    @Override
    public void pay(int amount){
        System.out.println("Paid using UPI: " + amount);
    }
}
