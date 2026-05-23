package com.LLD.Low_Level_design.Application.ParkingLot;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.*;
import com.LLD.Low_Level_design.Application.ParkingLot.Strategy.NearestFirstStrategy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException  {

        List<ParkingSpot> spots = Arrays.asList(
                new ParkingSpot("S1", VehicleType.CAR),
                new ParkingSpot("S2", VehicleType.BIKE),
                new ParkingSpot("S3", VehicleType.TRUCK)
        );

        ParkingFloor floor = new ParkingFloor("F1", spots);
        ParkingLot lot = new ParkingLot(Arrays.asList(floor));

        ParkingService service = new ParkingService(lot, new NearestFirstStrategy());

        Vehicle bike = new Bike("BIKE-123");
        Ticket ticket1 = service.parkVehicle(bike);

        Vehicle truck = new Truck("Truck-256");
        Ticket ticket2 = service.parkVehicle(truck);

        System.out.println("Ticket Issued: ");
        System.out.println(ticket1);
        System.out.println(ticket2);

        Thread.sleep(2000);

        Receipt receipt1 = service.unparkVehicle(ticket1.getTicketId());
        Receipt receipt2 = service.unparkVehicle(ticket2.getTicketId());
        System.out.println("Receipt: $" + receipt1.getAmount());
        System.out.println("Receipt2: $" + receipt2.getAmount());

    }
}
