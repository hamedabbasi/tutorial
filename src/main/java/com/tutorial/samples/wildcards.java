package com.tutorial.samples;

import java.util.ArrayList;
import java.util.List;

public class wildcards {
    public static void main(String[] args) {

        // 1. Upper Bounded Wildcards
        // This means that list being passed can be of any field or subclass of that field.
        List<? extends Number> list1 = new ArrayList<>();

        // 2. Lower Bounded Wildcards:
        // Here arguments can be Integer or superclass of Integer(which is Number).
        List<? super Integer> list2 = new ArrayList<>();

        // 3. Unbounded Wildcard:
        // This wildcard type is specified using the wildcard character (?), for example, List. This is called a list of unknown types.
        List<?> list3 = new ArrayList<>();

    }
}
