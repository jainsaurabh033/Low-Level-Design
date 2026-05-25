package com.LLD.Low_Level_design.Application.Elevator.Model.elevator;

public class Door {
    private DoorState state;

    public Door(){
        this.state = state;
    }

    public void open(){
        state = DoorState.OPEN;
        System.out.println("Door Opened");
    }

    public void close(){
        state = DoorState.CLOSED;
        System.out.println("Door Closed");
    }

    public DoorState getState(){
        return state;
    }
}
