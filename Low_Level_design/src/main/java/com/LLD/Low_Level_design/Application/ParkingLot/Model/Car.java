package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;

public class Car extends Vehicle{
    public Car(String number){
        super(number, VehicleType.CAR);
    }
}
