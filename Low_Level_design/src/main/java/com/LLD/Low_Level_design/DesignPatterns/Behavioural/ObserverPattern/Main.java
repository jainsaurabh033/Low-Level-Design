package com.LLD.Low_Level_design.DesignPatterns.Behavioural.ObserverPattern;

public class Main {
    public static void main(String[] args){
        WeatherStation station = new WeatherStation();

        Observer mobile = new MobileDisplay();
        Observer tv = new TVDisplay();

        station.addObserver(mobile);
        station.addObserver(tv);

        station.setTemperature(35);
    }
}
