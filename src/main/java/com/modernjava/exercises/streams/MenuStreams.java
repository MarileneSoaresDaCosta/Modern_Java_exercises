package com.modernjava.exercises.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MenuStreams {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("vegan sandwich", true, 300, Dish.Type.OTHER),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER ),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

//        System.out.println("complete list: " + menu);
        System.out.println("Filtering >>");
        // example - Java 8 in Action, pg 106
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> {
                            System.out.println("filtering " + d.getName());
                            return d.getCalories() > 300;
                        })
//                        .map(Dish::getName)
                        .map(d -> {
                            System.out.println("mapping " + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .toList();

        System.out.println("=== Three high calorie dishes: " +threeHighCaloricDishNames);

        /* filtering with a predicate - chapter 5
         */
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println("=== Vegetarian Menu: " + vegetarianMenu);

        /* filtering unique elements - chapter 5
         */
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        // returns 2 and 4

        /* chapter 5 - truncating a stream and skipping elements in a stream
        limit(n) - only the first n elements that match the predicate are selected, and the result is immediately returned - don't assume any order as this method also works on unordered streams;
        skip(n) skips the first n elements of a stream. It is complementary to limit()
         */

        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
//                .limit(2)
                .skip(2)
                .collect(toList());


        System.out.println("dishes: " + dishes);

        System.out.println("Mapping >>");
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        System.out.println("Names mapped: " + dishNames);

        /* Chaining another map
        *
         */
        List<Integer> dishNamesLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println("Names' lengths mapped: " + dishNamesLengths);

        /* Flattening streams
         */
        System.out.println("Flattening streams >>");
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split(""))// converts each word into a array
                .flatMap(Arrays::stream) //flattens each generated stream into a single stream
                .distinct()
                .collect(Collectors.toList());
        System.out.println("flattened unique chars: " +uniqueCharacters);

        /* using flatmap to concatenate two lists of integers into a list of pairs */
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> {
                            return numbers2.stream()
                                    .filter(j -> (i+j) % 3 == 0)
                                    .map(j -> {
                                        System.out.println(i + " " + j);
                                        return new int[]{i, j};
                                    });
                        }
                )
                .collect(toList());

        /* Is there an element in the stream matching the given predicate?
        * Finding and matching
         */

        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("(using anyMatch()) The menu is (somewhat) vegetarian friendly");
        }
        /* using Optional here because findAny might return a null
         * using Optional avoid bugs related to null checking
         */
        // >> what is wrong with this?
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println("using ifPresent(): " + d.getName()) );

        /* using Reduce */

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers3.stream().reduce(0, Integer::sum);
        System.out.println("sum using reduce: " +sum);

        int prod = numbers3.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product using reduce: " +prod);

        Optional<Integer> max = numbers3.stream().reduce(Integer::max);
        Optional<Integer> min = numbers3.stream().reduce(Integer::min);
        System.out.println("max: " + max + " and min: " +min);

        // counting the number of dishes in a stream
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("counting with map-reduce: " + count);

        // which is equivalent to .count()
        long count1 = menu.stream().count();
        System.out.println("counting with .count(): " +count1);

        // Stream.of
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

       // streams from functions
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);


        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


    }
}
