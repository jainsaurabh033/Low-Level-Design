package com.LLD.Low_Level_design.Application.Elevator.Strategy;

import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Elevator;
import com.LLD.Low_Level_design.Application.Elevator.Model.request.ExternalRequest;

import java.util.List;

public interface ElevatorSelectionStrategy {
    Elevator selectElevator(List<Elevator> elevators, ExternalRequest request);
}
