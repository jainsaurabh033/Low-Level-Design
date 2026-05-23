package com.LLD.Low_Level_design.DesignPatterns.Structural.DecoratorDesignPattern;

abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}
