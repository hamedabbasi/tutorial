package com.tutorial.desingpatterns.creational.abstractfactory;

public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}
