package com.modernjava.exercises.streams;

import java.util.Arrays;
import java.util.List;

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

        System.out.println("complete list: " + menu);

        // example - Java 8 in Action, pg 106
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .toList();

        System.out.println("=== Three high calorie dishes: " +threeHighCaloricDishNames);
    }
}
