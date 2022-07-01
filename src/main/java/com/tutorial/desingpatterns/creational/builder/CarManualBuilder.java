package com.tutorial.desingpatterns.creational.builder;

public class CarManualBuilder implements Builder {

    private Manual manual;

    public CarManualBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        manual = new Manual();
    }

    @Override
    public void setSeats(int number) {
        manual.appendUserManualText("This car has " + number + " seats.");
    }

    @Override
    public void setEngine(String engine) {
        manual.appendUserManualText("We used " + engine + " engine in this car.");
    }

    @Override
    public void setTripComputer() {
        manual.appendUserManualText("Trip computer available in this model.");
    }

    @Override
    public void setGPS() {
        manual.appendUserManualText("You can use provided GPS for navigation.");
    }

    public Manual build() {
        return this.manual;
    }
}
