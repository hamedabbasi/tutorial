package com.tutorial.desingpatterns.creational.builder;

/**
 * A car can have a GPS, trip computer and some number of
 * seats. Different models of cars (sports car, SUV,
 * cabriolet) might have different features installed or
 * enabled.
 */
public class Car {
    public int seats = 4;
    public String engine;
    public boolean hasTripComputer;
    public boolean hasGPS;
}
