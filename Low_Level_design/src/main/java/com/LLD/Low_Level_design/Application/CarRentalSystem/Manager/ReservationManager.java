package com.LLD.Low_Level_design.Application.CarRentalSystem.Manager;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.ReservationStatus;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleStatus;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.Reservation;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.User;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.Vehicle;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ReservationManager {
    private final Map<String, Reservation> reservations;

    private final Map<String, ReentrantLock> vehicleLocks;

    public ReservationManager(){

        reservations = new ConcurrentHashMap<>();
        vehicleLocks = new ConcurrentHashMap<>();
    }

    public Reservation createReservation(User user, Vehicle vehicle, LocalDate from, LocalDate to){
        vehicleLocks.putIfAbsent(vehicle.getVehicleId(), new ReentrantLock());

        ReentrantLock lock = vehicleLocks.get(vehicle.getVehicleId());
        lock.lock();

        try{
            if(vehicle.getStatus() != VehicleStatus.AVAILABLE){
                System.out.println("Vehicle already booked!");
                return null;
            }

            vehicle.setStatus(VehicleStatus.RESERVED);

            String reservationId = UUID.randomUUID().toString();
            Reservation reservation = new Reservation(reservationId, user, vehicle, from, to);
            reservations.put(reservationId, reservation);
            return reservation;
        }
        finally{
            lock.unlock();
        }
    }

    public void completeReservation(String reservationId){
        Reservation reservation = reservations.get(reservationId);

        if(reservation == null){
            return;
        }

        reservation.setStatus(ReservationStatus.COMPLETED);
        reservation.getVehicle().setStatus(VehicleStatus.AVAILABLE);
    }
}
