package com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.Reservation;

public interface PricingStrategy {
    double calculatePrice(Reservation reservation);
}
