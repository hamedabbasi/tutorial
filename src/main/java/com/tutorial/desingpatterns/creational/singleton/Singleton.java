package com.tutorial.desingpatterns.creational.singleton;

/**
 * Singleton is a creational design pattern that lets you ensure that
 * a class has only one instance, while providing a global access point
 * to this instance.
 * <p>
 * The Singleton pattern solves two problems at the same time, violating
 * the Single Responsibility Principle:
 * 1- Ensure that a class has just a single instance.
 * 2- Provide a global access point to that instance.
 */
public final class Singleton {

    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
