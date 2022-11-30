package com.modernjava.exercises.lambdas;

import java.util.Comparator;

// implementing sort  - step 1
public class AppleComparator implements Comparator<Apple> {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
