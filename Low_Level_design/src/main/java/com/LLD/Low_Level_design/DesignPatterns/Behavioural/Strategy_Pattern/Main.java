package com.LLD.Low_Level_design.DesignPatterns.Behavioural.Strategy_Pattern;

public class Main {
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new UpiPayment());
        cart.checkout(1000);

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(2000);
    }
}
