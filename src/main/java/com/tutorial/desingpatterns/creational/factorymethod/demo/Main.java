package com.tutorial.desingpatterns.creational.factorymethod.demo;

import com.tutorial.desingpatterns.creational.factorymethod.Dialog;
import com.tutorial.desingpatterns.creational.factorymethod.HtmlDialog;
import com.tutorial.desingpatterns.creational.factorymethod.WindowsDialog;

public class Main {
    public static void main(String[] args) {
        String dialogType = "windows";
        Dialog dialog;
        if (dialogType.endsWith("windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }

        dialog.render();
    }
}
