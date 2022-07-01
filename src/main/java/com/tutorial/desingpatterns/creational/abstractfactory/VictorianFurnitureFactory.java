package com.tutorial.desingpatterns.creational.abstractfactory;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
}
