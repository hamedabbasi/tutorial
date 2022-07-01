package com.tutorial.desingpatterns.creational.factorymethod;

public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
