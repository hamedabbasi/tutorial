package com.tutorial.desingpatterns.creational.abstractfactory.demo;

import com.tutorial.desingpatterns.creational.abstractfactory.Chair;
import com.tutorial.desingpatterns.creational.abstractfactory.FurnitureFactory;
import com.tutorial.desingpatterns.creational.abstractfactory.ModernFurnitureFactory;
import com.tutorial.desingpatterns.creational.abstractfactory.VictorianFurnitureFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFurnitureFactory.createChair();
        FurnitureFactory victorianFurnitureFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFurnitureFactory.createChair();
    }
}
