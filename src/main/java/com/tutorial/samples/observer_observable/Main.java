package com.tutorial.samples.observer_observable;

public class Main {
    public static void main(String[] args) {
        AppUser appUser = new AppUser();
        MessageBoard messageBoard = new MessageBoard();

        messageBoard.addObserver(appUser);

        messageBoard.changeMessage("Hi there!");
    }
}
