package com.LLD.Low_Level_design.Application.ParkingLot.Strategy;

public class BikeFeeStrategy implements FeeCalculationStrategy{
    public double calculateFee(long minutes){
        return Math.max(10, minutes*0.2);
    }
}
