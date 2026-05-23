package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;

public abstract class Vehicle {
    private String number;
    private VehicleType type;

    public Vehicle(String number, VehicleType type){
        this.number = number;
        this.type = type;
    }

    public String getNumber(){
        return number;
    }

    public VehicleType getType(){
        return type;
    }
}
