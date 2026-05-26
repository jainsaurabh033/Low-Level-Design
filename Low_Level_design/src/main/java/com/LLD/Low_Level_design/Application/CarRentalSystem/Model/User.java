package com.LLD.Low_Level_design.Application.CarRentalSystem.Model;

public class User {
    private final String userId;
    private final String name;
    private final String licenseNumber;

    public User(String userId, String name, String licenseNumber){
        this.userId = userId;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public String getUserId(){
        return userId;
    }

    @Override
    public String toString(){
        return "User{" + "userId='" + userId + '\'' + ", name='" + name + '\'' + '}';
    }
}
