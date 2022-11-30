package com.modernjava.exercises.functionalinterfaces;

import java.util.function.Consumer;

public class ConsumerExample {



    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println("resulting string: " +s.toUpperCase());
        c1.accept("testing if this gets uppercased");

    }
}
