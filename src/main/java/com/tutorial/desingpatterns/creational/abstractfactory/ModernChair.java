package com.tutorial.desingpatterns.creational.abstractfactory;

public class ModernChair implements Chair{
    @Override
    public boolean hasLegs() {
        System.out.println("Modern hasLegs");
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("Modern sitOn");
    }
}
