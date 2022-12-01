package com.modernjava.exercises.functionalinterfaces;

public class FunctionExample1 {

    public static String performConcat(String str){
        return FunctionExample.addDefault.apply(str);
    }

    public static void main(String[] args) {
        String result = performConcat("hello");
        System.out.println("result: " +result);
    }
}
