package com.tutorial.desingpatterns.creational.builder;


/**
 * Builder is a creational design pattern that lets you construct
 * complex objects step by step. The pattern allows you to produce
 * different types and representations of an object using the same
 * construction code.
 */
public interface Builder {
    void reset();

    void setSeats(int number);

    void setEngine(String engine);

    void setTripComputer();

    void setGPS();
}
