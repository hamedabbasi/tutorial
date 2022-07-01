package com.tutorial.desingpatterns.creational.singleton.demo;

import com.tutorial.desingpatterns.creational.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance("FOO");
        Singleton instance2 = Singleton.getInstance("BAR");
        System.out.println(instance1.value);
        System.out.println(instance2.value);
    }
}
