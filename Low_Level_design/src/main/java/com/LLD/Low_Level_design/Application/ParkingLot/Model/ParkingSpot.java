package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;

public class ParkingSpot {
    private String id;
    private VehicleType type;
    private boolean isOccupied = false;
    private Vehicle vehicle;

    public ParkingSpot(String id, VehicleType type){
        this.id = id;
        this.type = type;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isOccupied = false;
    }

    public VehicleType getType(){
        return type;
    }

    public String getId(){
        return id;
    }
}
