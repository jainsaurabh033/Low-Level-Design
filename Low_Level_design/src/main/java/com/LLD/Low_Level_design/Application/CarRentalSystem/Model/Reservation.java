package com.LLD.Low_Level_design.Application.CarRentalSystem.Model;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.ReservationStatus;

import java.time.LocalDate;

public class Reservation {
    private final String reservationId;
    private final User user;
    private final Vehicle vehicle;

    private final LocalDate fromDate;
    private final LocalDate toDate;

    private ReservationStatus status;

    public Reservation(String reservationId, User user, Vehicle vehicle, LocalDate fromDate, LocalDate toDate){
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = ReservationStatus.CREATED;
    }

    public String getReservationId(){
        return reservationId;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public LocalDate getFromDate(){
        return fromDate;
    }

    public LocalDate getToDate(){
        return toDate;
    }

    public ReservationStatus getStatus(){
        return status;
    }

    public void setStatus(ReservationStatus status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", vehicle=" + vehicle.vehicleNumber +
                ", status=" + status +
                '}';
    }
}
