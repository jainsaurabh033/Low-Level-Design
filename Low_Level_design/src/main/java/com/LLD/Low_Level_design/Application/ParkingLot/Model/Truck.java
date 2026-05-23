package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;

public class Truck extends Vehicle{
    public Truck(String number){
        super(number, VehicleType.TRUCK);
    }
}
