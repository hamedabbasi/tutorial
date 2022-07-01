package com.tutorial.desingpatterns.creational.builder;

public class CarBuilder implements Builder {

    private Car car;

    public CarBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.car = new Car();
    }

    @Override
    public void setSeats(int number) {
        car.seats = number;
    }

    @Override
    public void setEngine(String engine) {
        car.engine = engine;
    }

    @Override
    public void setTripComputer() {
        car.hasTripComputer = true;
    }

    @Override
    public void setGPS() {
        car.hasGPS = true;
    }

    public Car build() {
        return this.car;
    }
}
