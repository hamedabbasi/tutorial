package com.tutorial.samples.consumersupplier;

import com.tutorial.data.Student;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConsumerAndSupplier {

    public ConsumerAndSupplier() {
        super();
    }

    public static void main(String[] args) {

        /**
         * They are functional interfaces.
         *
         * A Supplier is any method which takes no arguments and returns a value.
         * Its job is literally to supply an instance of an expected class. For
         * instance, every reference to a 'getter' method is a Supplier
         *
         * use : java.util.function.*
         */

        Consumer<Student> consumer = st -> System.out.println(st);
        Consumer<Student> consumer2 = System.out::println;

        Student student = new Student(1L, "John", "john.smith@gmail.com");
        consumer.accept(student);
        consumer2.accept(student);

        Supplier<String> supplier = () -> "this is sample test";
        System.out.println(supplier.get());

        Function<Student, String> getStudentName = st -> {
            return st.getName() + " , " + st.getEmail();
        };
        String name = getStudentName.apply(student);
        System.out.println(name);
    }
}
