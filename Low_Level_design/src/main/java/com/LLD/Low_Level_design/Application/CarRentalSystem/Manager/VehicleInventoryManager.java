package com.LLD.Low_Level_design.Application.CarRentalSystem.Manager;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleStatus;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManager {
    private final List<Vehicle> vehicles;

    public VehicleInventoryManager(){
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles(VehicleType type){
        List<Vehicle> result = new ArrayList<>();

        for(Vehicle vehicle : vehicles){
            if(vehicle.getVehicleType() == type && vehicle.getStatus() == VehicleStatus.AVAILABLE){
                result.add(vehicle);
            }
        }

        return result;
    }
}
