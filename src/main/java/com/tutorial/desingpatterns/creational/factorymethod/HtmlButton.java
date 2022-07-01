package com.tutorial.desingpatterns.creational.factorymethod;

public class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("rendering html button");
    }

    @Override
    public void onClick() {
        System.out.println("Html button onclick");
    }
}
