package com.LLD.Low_Level_design.Application.Elevator.Model.request;

import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Direction;

public class ExternalRequest {
    private final int floor;
    private final Direction direction;

    public ExternalRequest(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor(){
        return floor;
    }

    public Direction getDirection(){
        return direction;
    }
}
