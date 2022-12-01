package com.modernjava.exercises.functionalinterfaces;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* in this example we won't use static methods, but use an instance method just to show how lambdas can be used with either
 */
public class PredicateAndConsumerExample {

    Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
    Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println( name + " : " + activities);

    Consumer<Student> studentConsumer = (student -> {
        if(p1.and(p2).test(student)) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    private void printNameAndActivities(List<Student> studentList) {
        studentList.forEach(studentConsumer);
    }

    /* using a BiPredicate to test for two conditions */
    BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >=3 && gpa >= 3.9;

    Consumer<Student> studentConsumerBi = (student -> {
        if(biPredicate.test(student.getGradeLevel(), student.getGpa())) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    private void printNameAndActivities_Bi(List<Student> studentList) {
        System.out.println("printNameAndActivities_Bi");
        studentList.forEach(studentConsumerBi);
    }



    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new PredicateAndConsumerExample().printNameAndActivities(studentList);
        new PredicateAndConsumerExample().printNameAndActivities_Bi(studentList);

    }



}
