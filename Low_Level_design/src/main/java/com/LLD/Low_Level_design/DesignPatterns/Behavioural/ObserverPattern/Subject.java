package com.LLD.Low_Level_design.DesignPatterns.Behavioural.ObserverPattern;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
