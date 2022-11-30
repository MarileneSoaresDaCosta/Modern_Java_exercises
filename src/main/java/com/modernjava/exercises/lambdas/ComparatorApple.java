package com.modernjava.exercises.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class ComparatorApple {
    public static void main(String[] args) {

        /* chapter 3, 3.6.2 Constructor references */

        // creating a new apple, using a default constructor
        Supplier<Apple> c1 = Apple::new;
        // calling Supplier's get method will produce a new Apple
        Apple a1 = c1.get();
        System.out.println("a1: " +a1);

        // using the constructor with signature - since we have 2 args, we use BiFunction
        BiFunction<Integer, String, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(110, "green");
        System.out.println("a2: " +a2);

        // using one arg
        Function<Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(115);
        System.out.println("a3: " +a3);


        // creating a list of apples based on weights
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        // it is not allowing me to pass a constructor reference to the map method - see pg 87
//        List<Apple> apples = map(weights, Apple::new);


        List<Apple> apples = map(weights, Apple::new);
        System.out.println("apples: " +apples);

        // testing the sort methods
        System.out.println("sorting ======= regular class creation and instantiation");

        // using regular class creation and instantiation - notice that class Apple Comparator had to be in new file
        apples.sort(new AppleComparator());
        System.out.println("apples after sorting: " + apples);

        // new weights and apples, unsorted:
        List<Apple> apples1 = map(weights, Apple::new);

        // sorting using anonymous class
        apples1.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println("sorting ======= using anonymous class");
        System.out.println("apples1 after sorting : " + apples1);


        // sorting using lambdas
        List<Apple> apples2 = map(weights, Apple::new);
        apples2.sort((ap1, ap2) -> ap1.getWeight().compareTo(ap2.getWeight()));

        System.out.println("sorting ======= using lambdas");
        System.out.println("apples2 after sorting : " + apples2);

        // sorting using static helper 'comparing' and lambda
        List<Apple> apples3 = map(weights, Apple::new);
        Comparator<Apple> c = comparing((Apple a) -> a.getWeight());
        apples3.sort(comparing((a) -> a.getWeight()));

        System.out.println("sorting ======= using static helper 'comparing' and lambda");
        System.out.println("apples3 after sorting : " + apples3);


        // using method references
        List<Apple> apples4 = map(weights, Apple::new);
        apples4.sort(comparing(Apple::getWeight));
        System.out.println("sorting ======= using method references");
        System.out.println("apples4 after sorting : " + apples4);

    }

    private static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for(Integer e: list) {
            result.add(f.apply(e));
        }
        return result;
    }
}

