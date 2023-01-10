package com.modernjava.exercises.lambdas;


import java.io.InputStream;
import java.io.OutputStream;

public class RunnableLambdaExample {
    /* making this an executable class */
    public static void main(String[] args) {
        /* implementing the runnable - prior to Java 8 style
        * notice that we use the Runnable interface to represent a block of code to be executed
        * - using an anonymous class here!
        * We use Threads here because they are lightweight processes - executing a block of code on their own */

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable - prior to Java 8");
            }
        };

        /* pass the runnable interface to a thread */
        new Thread(runnable).start();

        /* java 8 lambda syntax: () -> {} */
        Runnable runnableLambda = () -> {
            System.out.println("Inside runnableLambda - After Java 8");
        };
        new Thread(runnableLambda).start();

        /* streamlined syntax examples */
        Runnable runnableLambda1 = () -> System.out.println("Inside runnableLambda 1 ");

        new Thread(runnableLambda1).start();

        new Thread(()-> System.out.println("Inside runnableLambda 2")).start();

        // example from book - Java 8 in Action
        Runnable r1 = () -> System.out.println("Hello World 1");
        




    }
}
