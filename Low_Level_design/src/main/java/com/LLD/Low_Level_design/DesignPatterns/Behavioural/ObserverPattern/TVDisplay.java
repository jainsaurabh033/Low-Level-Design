package com.LLD.Low_Level_design.DesignPatterns.Behavioural.ObserverPattern;

public class TVDisplay implements Observer{

    @Override
    public void update(int temperature){
        System.out.println("TV Display Updated: " + temperature);
    }
}
