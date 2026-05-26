package com.LLD.Low_Level_design.Application.CarRentalSystem.Service;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.Reservation;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy.PricingStrategy;

public class BillService {
    private final PricingStrategy priceStrategy;

    public BillService(PricingStrategy priceStrategy){
        this.priceStrategy = priceStrategy;
    }

    public double generateBill(Reservation reservation){
        return priceStrategy.calculatePrice(reservation);
    }
}
