package com.LLD.Low_Level_design.Application.CarRentalSystem.Model;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.ReservationStatus;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleStatus;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleType;

public abstract class Vehicle {
    public String vehicleId;
    public String vehicleNumber;
    public double pricePerDay;
    public VehicleType vehicleType;
    public VehicleStatus status;

    public Vehicle(String vehicleId, String vehicleNumber, double pricePerDay, VehicleType vehicleType){
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.pricePerDay = pricePerDay;
        this.vehicleType = vehicleType;
        this.status = VehicleStatus.AVAILABLE;
    }

    public String getVehicleId(){
        return vehicleId;
    }

    public double getPricePerDay(){
        return pricePerDay;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public VehicleStatus getStatus(){
        return status;
    }

    public void setStatus(VehicleStatus status){
        this.status = status;
    }

    @Override
    public String toString(){
        return "Vehicle{" + "vehicleId='" + vehicleId + "\'" + ", vehicleNumber='" + vehicleNumber + '\'' + ", type=" + vehicleType + ", status=" + status + '}';
    }
}
