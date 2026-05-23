package com.LLD.Low_Level_design.DesignPatterns.Behavioural.ObserverPattern;

public class MobileDisplay implements Observer{

    @Override
    public void update(int temperature){
        System.out.println("Mobile Display Updated: " + temperature);
    }
}
