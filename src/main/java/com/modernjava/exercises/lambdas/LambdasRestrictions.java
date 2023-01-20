package com.modernjava.exercises.lambdas;

import java.util.function.Consumer;

public class LambdasRestrictions {

    static int value = 4;
    public static void main(String[] args) {
        // local variable
        int i = 0;
        /* Restriction 1: we cannot use the same name of a local variable
         * either as a lambda parameter or inside the body of a lambda
         *
         * The code below will not compile, with error
         * "variable 'i' is already defined in the scope

        static Consumer<Integer> c1 = (i) -> {
            System.out.println(i);
        };
        *
        *
        */


        /* Restriction 2: we cannot reassign a value to a local variable

         */
//        int value = 4;

        Consumer<Integer> c2 = (j) -> {
            /* this is only allowed if value is not local:
             *  error: "Variable used in lambda expression should be final or effectively final"
             */
             value++;

            // this is allowed:
            System.out.println(value + j);
        };

        c2.accept(4);

    }
}
