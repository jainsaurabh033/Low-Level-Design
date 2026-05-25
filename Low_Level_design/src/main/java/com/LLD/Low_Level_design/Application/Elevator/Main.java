package com.LLD.Low_Level_design.Application.Elevator;

import com.LLD.Low_Level_design.Application.Elevator.Controller.ElevatorController;
import com.LLD.Low_Level_design.Application.Elevator.Model.building.Building;
import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Direction;
import com.LLD.Low_Level_design.Application.Elevator.Model.elevator.Elevator;
import com.LLD.Low_Level_design.Application.Elevator.Model.request.ExternalRequest;
import com.LLD.Low_Level_design.Application.Elevator.Model.request.InternalRequest;
import com.LLD.Low_Level_design.Application.Elevator.Strategy.ElevatorSelectionStrategy;
import com.LLD.Low_Level_design.Application.Elevator.Strategy.NearestElevatorStrategy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);
        Elevator elevator3 = new Elevator(3);

        List<Elevator> elevators = Arrays.asList(elevator1, elevator2, elevator3);

        for(Elevator elevator : elevators){
            Thread thread = new Thread(elevator);
            thread.start();
        }

        ElevatorSelectionStrategy strategy = new NearestElevatorStrategy();
        ElevatorController controller = new ElevatorController(elevators, strategy);

        Building building = new Building(20, controller);

        controller.submitExternalRequest(new ExternalRequest(5, Direction.UP));
        Thread.sleep(2000);

        controller.submitExternalRequest(new ExternalRequest(8, Direction.DOWN));
        Thread.sleep(2000);

        controller.submitExternalRequest(new ExternalRequest(2, Direction.UP));

        Thread.sleep(3000);

        elevator1.addInternalRequest(new InternalRequest(15));

        Thread.sleep(1000);

        elevator2.addInternalRequest(new InternalRequest(1));
    }
}
