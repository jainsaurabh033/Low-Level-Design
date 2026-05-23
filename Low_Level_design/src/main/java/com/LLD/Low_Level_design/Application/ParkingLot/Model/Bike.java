package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;

public class Bike extends Vehicle{
    public Bike(String number){
        super(number, VehicleType.BIKE);
    }
}
