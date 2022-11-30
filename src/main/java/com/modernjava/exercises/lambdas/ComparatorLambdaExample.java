package com.modernjava.exercises.lambdas;

import java.util.*;

public class ComparatorLambdaExample {
    // making class executable
    public static void main(String[] args) {

        // prior to Java 8 style
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /*  if equal, returns 0
                    if o1 > o2, returns  1
                    if o1 < o2, returns -1
                 */
                return o1.compareTo(o2);
            }
        };

        // calls the method
        System.out.println("Result of comparator is (expected = 1) : " + comparator.compare(3, 2));

        // After Java 8 style, using lambdas
        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
        System.out.println("Result of comparatorLambda is (expected = 1) : " + comparatorLambda.compare(3, 2));

        // After Java 17, replacing lambda with method reference - Comparator.naturalOrder
        Comparator<Integer> comparator17 = Integer::compareTo;
        System.out.println("Result of Comparator.naturalOrder is (expected = 1) : " + comparator17.compare(3, 2));

        /* trying an example with sorting */
        // create a list of random integers:
        List<Integer> newList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++ ){
            int rand = random.nextInt(100);
            newList.add(rand);
        }
        System.out.println("unsorted list: " + newList);

        newList.sort((a, b) -> a.compareTo(b));
        System.out.println("List after sorting: " +newList);

        // using method reference
        List<Integer> newList1 = new ArrayList<>();
        for(int i = 0; i < 10; i++ ){
            int rand = random.nextInt(100);
            newList1.add(rand);
        }
        System.out.println("unsorted list1 : " + newList1);

        newList1.sort(Integer::compareTo);
        System.out.println("List after sorting: " +newList1);

        /* Method References */
        List<String> str = Arrays.asList("a", "A", "b", "N", "B");
        // using lambda
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        List<String> strX = Arrays.asList("a", "A", "b", "N", "B");
        // using method reference
        strX.sort(String::compareToIgnoreCase);

        System.out.println("str: "+str + " strX: " +strX);
    }
}
