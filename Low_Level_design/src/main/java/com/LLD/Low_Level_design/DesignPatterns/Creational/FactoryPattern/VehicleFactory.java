package com.LLD.Low_Level_design.DesignPatterns.Creational.FactoryPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String type){
        if(type.equalsIgnoreCase("car")){
            return new Car();
        }
        else if(type.equalsIgnoreCase("bike")){
            return new Bike();
        }

        return null;
    }
}
