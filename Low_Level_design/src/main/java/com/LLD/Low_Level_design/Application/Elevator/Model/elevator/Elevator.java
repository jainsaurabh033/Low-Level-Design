package com.LLD.Low_Level_design.Application.Elevator.Model.elevator;

import com.LLD.Low_Level_design.Application.Elevator.Model.request.ExternalRequest;
import com.LLD.Low_Level_design.Application.Elevator.Model.request.InternalRequest;

import java.util.TreeSet;

public class Elevator implements Runnable{
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private final Door door;
    private final Dispaly display;

    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    public Elevator(int id){
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.door = new Door();
        this.display = new Dispaly();
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>();
    }

    public int getId(){
        return id;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public Direction getDirection(){
        return direction;
    }

    public ElevatorState getState(){
        return state;
    }

    public synchronized void addExternalRequest(ExternalRequest request){
        if(request.getDirection() == Direction.UP){
            upRequests.add(request.getFloor());
        }
        else{
            downRequests.add(request.getFloor());
        }
        notifyAll();
    }

    public synchronized void addInternalRequest(InternalRequest request){
        int destination = request.getDestinationFloor();

        if(destination > currentFloor){
            upRequests.add(destination);
        }
        else if(destination < currentFloor){
            downRequests.add(destination);
        }

        notifyAll();
    }

    @Override
    public void run(){
        while(true){
            try{
                synchronized (this){
                    while(upRequests.isEmpty() && downRequests.isEmpty()){
                        state = ElevatorState.IDLE;
                        direction = Direction.IDLE;

                        System.out.println("Elevator " + id + " waiting...");

                        wait();
                    }
                }

                if(direction == Direction.IDLE){
                    if(!upRequests.isEmpty()){
                        direction = Direction.UP;
                    }
                    else{
                        direction = Direction.DOWN;
                    }
                }

                if(direction == Direction.UP){
                    processUpRequests();
                }
                else{
                    processDownRequests();
                }
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    private void processUpRequests(){
        while(true){
            Integer destination;

            synchronized (this){
                destination = upRequests.pollFirst();
            }

            if(destination == null){
                break;
            }

            moveToFloor(destination);
        }

        synchronized (this){
            if(!downRequests.isEmpty()){
                direction = Direction.DOWN;
            }
            else{
                direction = Direction.IDLE;
            }
        }
    }

    private void processDownRequests(){
        while(true){
            Integer destination;

            synchronized (this){
                destination = downRequests.pollFirst();
            }

            if(destination == null){
                break;
            }

            moveToFloor(destination);
        }

        synchronized (this){
            if(!upRequests.isEmpty()){
                direction = Direction.UP;
            }
            else{
                direction = Direction.IDLE;
            }
        }
    }

    private void moveToFloor(int destinationFloor){
        System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to floor " + destinationFloor);

        state = ElevatorState.MOVING;

        while(currentFloor != destinationFloor){
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }

            if(currentFloor < destinationFloor){
                currentFloor++;
                direction = Direction.UP;
            }
            else{
                currentFloor--;
                direction = Direction.DOWN;
            }

            display.show(currentFloor, direction);
        }

        state = ElevatorState.STOPPED;

        System.out.println("Elevator " + id + " reached floor " + currentFloor);

        openDoor();
        closeDoor();
    }

    private void openDoor(){
        door.open();
    }

    private void closeDoor(){
        door.close();
    }
}
