package com.tutorial.desingpatterns.creational.prototype.demo;

import com.tutorial.desingpatterns.creational.prototype.Circle;
import com.tutorial.desingpatterns.creational.prototype.Rectangle;
import com.tutorial.desingpatterns.creational.prototype.Shape;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.radius = 30;

        Rectangle rectangle1 = new Rectangle();
        rectangle1.width = 20;
        rectangle1.height = 70;

        // cloning...
        Shape circle2 = circle1.clone();
        Shape rectangle2 = rectangle1.clone();

        // comparing...
        System.out.println(circle1.equals(circle2));
        System.out.println(rectangle1.equals(rectangle2));

    }
}
