package com.tutorial.desingpatterns.creational.factorymethod;

/**
 * Factory method is a creational design pattern which solves the problem
 * of creating product objects without specifying their concrete classes.
 *
 * Factory Method is a creational design pattern that provides an interface
 * for creating objects in a superclass, but allows subclasses to alter the
 * type of objects that will be created.
 *
 * Factory Method defines a method, which should be used for creating objects
 * instead of direct constructor call (new operator). Subclasses can override
 * this method to change the class of objects that will be created.
 */
public abstract class Dialog {

    public void render() {
        // ... other code ...
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}
