package com.LLD.Low_Level_design.DesignPatterns.Structural.DecoratorDesignPattern;

public class Main {
    public static void main(String[] args){

        Coffee coffee = new PlainCoffee();

        coffee = new MilkDecorator(coffee);

        coffee = new ChocolateDecorator(coffee);

        System.out.println(coffee.getDescription());

        System.out.println("Total Cost: " + coffee.getCost());
    }
}
