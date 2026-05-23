package com.LLD.Low_Level_design.DesignPatterns.Creational.FactoryPattern;

public class Main {
    public static void main(String[] args){
        Vehicle v1 = VehicleFactory.getVehicle("car");
        v1.drive();

        Vehicle v2 = VehicleFactory.getVehicle("Bike");
        v2.drive();
    }
}
