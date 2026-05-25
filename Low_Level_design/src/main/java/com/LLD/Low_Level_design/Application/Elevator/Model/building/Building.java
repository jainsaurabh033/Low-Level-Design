package com.LLD.Low_Level_design.Application.Elevator.Model.building;

import com.LLD.Low_Level_design.Application.Elevator.Controller.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Floor> floors;
    private final ElevatorController controller;

    public Building(int totalFloors, ElevatorController elevatorController){
        this.controller = elevatorController;
        this.floors = new ArrayList<>();

        for(int i = 0;i<totalFloors;i++){
            floors.add(new Floor(i));
        }
    }

    public ElevatorController getController(){
        return controller;
    }
}
