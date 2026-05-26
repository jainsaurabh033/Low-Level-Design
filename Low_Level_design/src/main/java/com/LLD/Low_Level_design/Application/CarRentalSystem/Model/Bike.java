package com.LLD.Low_Level_design.Application.CarRentalSystem.Model;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleType;

public class Bike extends Vehicle{
    public Bike(String vehicleId, String vehicleNumber, double pricePerDay){
        super(vehicleId, vehicleNumber, pricePerDay, VehicleType.BIKE);
    }
}
