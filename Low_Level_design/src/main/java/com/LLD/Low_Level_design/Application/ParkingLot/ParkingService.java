package com.LLD.Low_Level_design.Application.ParkingLot;

import com.LLD.Low_Level_design.Application.ParkingLot.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.ParkingLot.Model.*;
import com.LLD.Low_Level_design.Application.ParkingLot.Strategy.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final SpotAssignmentStrategy strategy;
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private final Map<VehicleType, FeeCalculationStrategy> feeStrategies = new HashMap<>();
    private int ticketCounter = 0;
    private int receiptCounter = 0;

    public ParkingService(ParkingLot lot, SpotAssignmentStrategy strategy){
        this.parkingLot = lot;
        this.strategy = strategy;
        initFeeStrategies();
    }

    private void initFeeStrategies(){
        feeStrategies.put(VehicleType.CAR, new CarFeeStrategy());
        feeStrategies.put(VehicleType.TRUCK, new TruckFeeStrategy());
        feeStrategies.put(VehicleType.BIKE, new BikeFeeStrategy());
    }

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot = strategy.findSpot(parkingLot.getFloors(), vehicle.getType());
        if(spot == null) return null;

        spot.assignVehicle(vehicle);
        String ticketId = "Ticket-" + (++ticketCounter);
        Ticket ticket = new Ticket(ticketId, vehicle, spot);
        activeTickets.put(ticketId,ticket);
        return ticket;
    }

    public Receipt unparkVehicle(String ticketId){
        Ticket ticket = activeTickets.remove(ticketId);
        if(ticket == null) return null;

        ParkingSpot spot = ticket.getSpot();
        spot.removeVehicle();

        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        long minutes = duration.toMinutes();

        FeeCalculationStrategy feeStrategy = feeStrategies.get(ticket.getVehicle().getType());
        double fee = feeStrategy.calculateFee(minutes);

        return new Receipt("Receipt-" + (++receiptCounter), fee);
    }
}
