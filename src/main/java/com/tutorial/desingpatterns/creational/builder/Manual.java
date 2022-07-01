package com.tutorial.desingpatterns.creational.builder;

/**
 * Each car should have a user manual that corresponds to
 * the car's configuration and describes all its features.
 */
public class Manual {
    private String manual = "";

    public void appendUserManualText(String line) {
        this.manual += "\r\n" + line;
    }

    public String getManual() {
        return manual;
    }
}
