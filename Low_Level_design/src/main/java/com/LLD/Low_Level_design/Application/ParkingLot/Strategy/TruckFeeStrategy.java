package com.LLD.Low_Level_design.Application.ParkingLot.Strategy;

public class TruckFeeStrategy implements FeeCalculationStrategy{
    @Override
    public double calculateFee(long minutes){
        return Math.max(20, minutes*0.5);
    }
}
