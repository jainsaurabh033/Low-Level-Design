package com.LLD.Low_Level_design.Application.Elevator.Model.request;

public class InternalRequest {
    private final int destinationFloor;

    public InternalRequest(int destinationFloor){
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor(){
        return destinationFloor;
    }
}
