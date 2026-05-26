package com.LLD.Low_Level_design.Application.CarRentalSystem;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Enum.VehicleType;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Model.*;

import com.LLD.Low_Level_design.Application.CarRentalSystem.Service.BillService;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy.DailyPricingStrategy;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy.PaymentStrategy;
import com.LLD.Low_Level_design.Application.CarRentalSystem.Strategy.UPIPayment;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // Create Store
        Store store = new Store("StORE_1", "Nagpur");

        Vehicle car1 = new Car("V1", "MH31AB1234",2000);
        Vehicle car2 = new SUV("V2", "MH31XY9999", 3500);

        store.addVehicle(car1);
        store.addVehicle(car2);

        // Create User

        User user = new User("U1", "Saurabh", "DL12345");

        // Search Vehicles
        List<Vehicle> availableCars = store.searchVehicles(VehicleType.CAR);
        System.out.println("Available Cars:");

        for(Vehicle vehicle : availableCars){
            System.out.println(vehicle);
        }

        Reservation reservation = store.createReservation(user, car1, LocalDate.now(), LocalDate.now().plusDays(3));

        if(reservation != null){

            System.out.println("\nReservation Successfull");
            System.out.println(reservation);

            BillService billService = new BillService(new DailyPricingStrategy());

            double amount = billService.generateBill(reservation);

            System.out.println("\n Total Bill: " + amount);

            // PAYMENT
            PaymentStrategy payment = new UPIPayment();
            payment.pay(amount);

            store.completeReservation(reservation.getReservationId());
        }
    }
}
