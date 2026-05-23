package com.LLD.Low_Level_design.Application.ParkingLot.Strategy;

public class CarFeeStrategy implements FeeCalculationStrategy{
    public double calculateFee(long minutes){
        return Math.max(20, minutes * 0.5);
    }
}
