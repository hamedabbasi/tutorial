package com.tutorial.desingpatterns.creational.builder.demo;

import com.tutorial.desingpatterns.creational.builder.Car;
import com.tutorial.desingpatterns.creational.builder.CarBuilder;
import com.tutorial.desingpatterns.creational.builder.CarManualBuilder;
import com.tutorial.desingpatterns.creational.builder.Manual;

public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        carBuilder.setSeats(5);
        carBuilder.setEngine("Super Sport");
        carBuilder.setTripComputer();
        carBuilder.setGPS();
        Car SUV = carBuilder.build();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        manualBuilder.setSeats(SUV.seats);
        manualBuilder.setEngine(SUV.engine);
        manualBuilder.setTripComputer();
        manualBuilder.setGPS();
        Manual manual = manualBuilder.build();

        System.out.println(manual.getManual());
    }
}
