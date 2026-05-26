package com.LLD.Low_Level_design.Application.CarRentalSystem.Model;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Manager.ReservationManager;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Manager.VehicleInventoryManager;

import java.time.LocalDate;
import java.util.List;

public class Store {
    private final String storeId;
    private final String city;

    private final VehicleInventoryManager inventoryManager;

    private final ReservationManager reservationManager;

    public Store(String storeId, String city){
        this.storeId = storeId;
        this.city = city;
        inventoryManager = new VehicleInventoryManager();
        reservationManager = new ReservationManager();
    }

    public void addVehicle(Vehicle vehicle){
        inventoryManager.addVehicle(vehicle);
    }

    public List<Vehicle> searchVehicles(VehicleType type){
        return inventoryManager.getAvailableVehicles(type);
    }

    public Reservation createReservation(User user, Vehicle vehicle, LocalDate from, LocalDate to){
        return reservationManager.createReservation(user, vehicle, from, to);
    }

    public void completeReservation(String reservationId){
        reservationManager.completeReservation(reservationId);
    }
}
