package com.tutorial.samples.failfast;

import java.util.ArrayList;
import java.util.List;

public class FailFastTest {
    public static void main(String[] args) {
        List<String> testFailFast = new ArrayList<>();
        testFailFast.add("test1");
        testFailFast.add("test2");
        testFailFast.add("test3");
        testFailFast.add("test4");
        for (String s : testFailFast) {
            testFailFast.remove(1);
            System.out.println(s);
        }
    }
}
