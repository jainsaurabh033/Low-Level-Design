package com.LLD.Low_Level_design.Application.Elevator.Strategy;

import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Direction;
import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.ElevatorState;
import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Elevator;
import com.LLD.Low_Level_design.Application.Elevator.Model.request.ExternalRequest;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    @Override
    public Elevator selectElevator(List<Elevator> elevators, ExternalRequest request){
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator elevator : elevators){
            if(canServeRequest(elevator, request)){
                int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
                if(distance < minDistance){
                   minDistance = distance;
                   bestElevator = elevator;
                }
            }
        }

        if(bestElevator == null){
            bestElevator = elevators.get(0);
        }

        return bestElevator;
    }

    private boolean canServeRequest(Elevator elevator, ExternalRequest request){
        if(elevator.getState() == ElevatorState.MAINTENANCE){
            return false;
        }

        if(elevator.getDirection() == Direction.IDLE){
            return true;
        }

        if(elevator.getDirection() == request.getDirection()){
            if(request.getDirection() == Direction.UP && request.getFloor() >= elevator.getCurrentFloor()){
                return true;
            }
        }

        if(request.getDirection() == Direction.DOWN && request.getFloor() <= elevator.getCurrentFloor()){
            return true;
        }

        return false;
    }
}
