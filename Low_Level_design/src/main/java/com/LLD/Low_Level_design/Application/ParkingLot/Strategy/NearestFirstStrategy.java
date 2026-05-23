package com.LLD.Low_Level_design.Application.ParkingLot.Strategy;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.ParkingFloor;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.ParkingSpot;

import java.util.List;

public class NearestFirstStrategy implements SpotAssignmentStrategy{
    public ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType type){
        for(ParkingFloor floor : floors){
            for(ParkingSpot spot : floor.getSpots()){
                if(spot.isAvailable() && spot.getType() == type){
                    return spot;
                }
            }
        }

        return null;
    }
}
