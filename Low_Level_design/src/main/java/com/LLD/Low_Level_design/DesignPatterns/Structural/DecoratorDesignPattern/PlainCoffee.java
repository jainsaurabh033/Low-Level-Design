package com.LLD.Low_Level_design.DesignPatterns.Structural.DecoratorDesignPattern;

public class PlainCoffee implements Coffee{

    @Override
    public String getDescription(){
        return "Plain Coffee";
    }

    @Override
    public int getCost(){
        return 100;
    }
}
