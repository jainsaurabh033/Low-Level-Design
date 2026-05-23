package com.LLD.Low_Level_design.DesignPatterns.Behavioural.Strategy_Pattern;

public class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        paymentStrategy.pay(amount);
    }
}
