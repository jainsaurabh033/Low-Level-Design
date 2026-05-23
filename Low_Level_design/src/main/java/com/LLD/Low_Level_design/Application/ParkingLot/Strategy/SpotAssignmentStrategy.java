package com.LLD.Low_Level_design.Application.ParkingLot.Strategy;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.ParkingFloor;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.ParkingSpot;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.Vehicle;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType type);
}
