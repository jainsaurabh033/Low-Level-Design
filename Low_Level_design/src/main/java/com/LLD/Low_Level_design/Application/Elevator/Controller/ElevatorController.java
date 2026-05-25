package com.LLD.Low_Level_design.Application.Elevator.Controller;

import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Elevator;
import com.LLD.Low_Level_design.Application.Elevator.Model.request.ExternalRequest;
import com.LLD.Low_Level_design.Application.Elevator.Strategy.ElevatorSelectionStrategy;

import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;
    private final ElevatorSelectionStrategy strategy;

    public ElevatorController(List<Elevator> elevators, ElevatorSelectionStrategy strategy){
        this.elevators = elevators;
        this.strategy = strategy;
    }

    public void submitExternalRequest(ExternalRequest request){

        Elevator elevator = strategy.selectElevator(elevators, request);

        System.out.println("Request at floor " + request.getFloor() + " assigned to Elevator " + elevator.getId());

        elevator.addExternalRequest(request);
    }
}
