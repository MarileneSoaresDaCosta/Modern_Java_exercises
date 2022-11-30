package com.modernjava.exercises.functionalinterfaces;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    // implementation of Consumer for printing students' info
    static Consumer<Student> c1 = (student) -> System.out.println(student);
    static Consumer<Student> c2 = (student) -> System.out.print(student.getName()+": ");
    static Consumer<Student> c3 = (student) -> System.out.println(student.getActivities());

    public static void printStudents(){
        System.out.println("printStudents === ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        // inside forEach(Consumer c) there is a call to accept on the consumer instance passed
        studentList.forEach(c1);
    }

    public static void  printNameAndActivities(){
        System.out.println("printNameAndActivities === ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2.andThen(c3)); // consumer chaining
    }

    // naive implementation, just to test more chaining
    public static void  printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition === ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        // here we're not passing the consumer implementation into forEach, but a lambda!
        // .. in a way, it is overriding the forEach, since we have to add the accept anyways.
        // at a later example, we'll see a better implementation of this filter
        studentList.forEach((student -> {
            if(student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                c2.andThen(c3).accept(student);
            }
        }));
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println("resulting string: " +s.toUpperCase());
        c1.accept("this got uppercased!");
        printStudents();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }
}
