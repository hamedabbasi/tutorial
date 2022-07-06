package com.tutorial.samples.comparison;

public class MaybeFlyweight {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true

        a = 200;
        b = 200;
        System.out.println(a == b); // false

        Long l1 = new Long(300);
        Long l2 = new Long(300);
        System.out.println(l1 == l2);  // false

        Long a1 = 300L;
        Long b1 = 300L;
        System.out.println(a1 == b1);  // false

        long aa = new Long(400);
        long bb = new Long(400);
        System.out.println(aa == bb); // true
    }
}
