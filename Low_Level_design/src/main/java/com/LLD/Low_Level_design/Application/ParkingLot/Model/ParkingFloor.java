package com.LLD.Low_Level_design.Application.ParkingLot.Model;

import java.util.List;

public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> spots;

    public ParkingFloor(String floorId, List<ParkingSpot> spots){
        this.floorId = floorId;
        this.spots = spots;
    }

    public List<ParkingSpot> getSpots(){
        return spots;
    }
}
