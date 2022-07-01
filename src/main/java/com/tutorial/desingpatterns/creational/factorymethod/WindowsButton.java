package com.tutorial.desingpatterns.creational.factorymethod;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("rendering windows button");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button onclick");
    }
}
