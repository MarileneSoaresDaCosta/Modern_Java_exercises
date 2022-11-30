package com.modernjava.exercises.functionalinterfaces;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    // applying BiConsumer to similar case in Consumer, passing two args
    public static void nameAndActivities(){
        System.out.println("Printing name and activities");
        // implement BiConsumer
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> biConsumer.accept(student.getName(), student.getActivities())));
    }

    public static void main(String[] args) {

        // using BiConsumer with strings
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a : " + a + " b : " + b);
        };
        biConsumer.accept("Tom", "Jerry");

        // with numbers
        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("multiply : " + (a *  b));
        };
        multiply.accept(12, 5);

        BiConsumer<Integer, Integer> divide = (a, b) -> {
            System.out.println("division : " + (a /  b));
        };
        multiply.andThen(divide).accept(10, 5);

        divide.andThen(multiply).accept(11, 2);

        nameAndActivities();
    }
}
