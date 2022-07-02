package com.tutorial.samples.observer_observable;

import java.util.Observable;
import java.util.Observer;

public class AppUser implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an {@code Observable} object's
     * {@code notifyObservers} method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Message board changed!" + arg);
    }
}
