package com.tutorial.desingpatterns.creational.prototype;

import java.util.Objects;

/**
 * Prototype is a creational design pattern that lets you copy
 * existing objects without making your code dependent on their
 * classes.
 */
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    // A regular constructor.
    public Shape() {
        System.out.println("default constructor of shape");
    }

    // The prototype constructor. A fresh object is initialized
    // with values from the existing object.
    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
}
