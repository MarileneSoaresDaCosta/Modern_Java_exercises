package com.modernjava.exercises.functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> upperName = (name) -> name.toUpperCase();
    static Function<String, String> addDefault = (name) -> name.concat("_default");

    public static void main(String[] args) {
        System.out.println("Result of upperName is : " + upperName.apply("java8"));
        System.out.println("Result of upperName.andThen(addDefault) is : " + upperName.andThen(addDefault).apply("java8"));
        System.out.println("Result of upperName.compose(addDefault) is : " + upperName.compose(addDefault).apply("java8"));


    }
}
