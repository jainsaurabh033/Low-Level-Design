package com.LLD.Low_Level_design.DesignPatterns.Structural.DecoratorDesignPattern;

public class ChocolateDecorator extends CoffeeDecorator{

    public ChocolateDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription() + ", Chocolate";
    }

    @Override
    public int getCost(){
        return coffee.getCost() + 30;
    }

}
