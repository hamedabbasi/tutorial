package com.tutorial.desingpatterns.creational.abstractfactory;

public class VictorianChair implements Chair {
    @Override
    public boolean hasLegs() {
        System.out.println("Victorian hasLegs");
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("Victorian sitOn");
    }
}
