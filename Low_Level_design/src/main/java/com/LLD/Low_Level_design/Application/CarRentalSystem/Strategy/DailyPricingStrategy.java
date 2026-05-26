package com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.Reservation;

public class DailyPricingStrategy implements PricingStrategy {
    public double calculatePrice(Reservation reservation){
        long totalDays = reservation.getFromDate().until(reservation.getToDate()).getDays();

        return totalDays * reservation.getVehicle().getPricePerDay();
    }
}

