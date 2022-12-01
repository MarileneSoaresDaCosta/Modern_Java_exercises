package com.modernjava.exercises.functionalinterfaces;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    // implementing the interface
    static Predicate<Integer> p = (i) -> i % 2 == 0;
    static Predicate<Integer> p1 = (i) -> i % 5 == 0;

    // using the student data
    static Predicate<Student> p2 = (student) -> student.getGradeLevel() >=3;
    static Predicate<Student> p3 = (student) -> student.getGpa() >=3.9;

    public static void predicateAnd(){
        System.out.println("predicateAnd:  ==> ");
        System.out.println(p.and(p1).test(10)); // predicate chaining
        System.out.println(p.and(p1).test(9)); // predicate chaining
    }

    public static void predicateOr(){
        System.out.println("predicateOr:  ==> ");
        System.out.println(p.or(p1).test(10)); // predicate chaining
        System.out.println(p.or(p1).test(8)); // predicate chaining
    }

    public static void predicateNegate(){
        System.out.println("predicateOr:  ==> ");
        System.out.println(p.or(p1).negate().test(8)); // predicate chaining
    }

    public static void filterStudentsByGradeLevel(){
        System.out.println("filterStudentsByGradeLevel");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudentsByGpa(){
        System.out.println("filterStudentsByGpa");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(p3.test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudentsByGradeLevelAndGpa(){
        System.out.println("filterStudentsByGradeLevelAndGPA");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(p3.and(p2).test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudents( List<Student> studentsList, Predicate <Student> p) {
        System.out.println("filterStudents by a parameterized predicate: ");
        studentsList.forEach((student -> {
            if (p.test(student)) {
                System.out.println(student);
            }
        }));
    }


    public static void main(String[] args) {
//        System.out.println(p.test(4));
//        predicateAnd();
//        predicateOr();
//        predicateNegate();
//
//        filterStudentsByGradeLevel();
//        filterStudentsByGpa();
//        filterStudentsByGradeLevelAndGpa();
        Predicate<Student> p4 = (Student student) -> student.getGender().equals("female");
        filterStudents(StudentDataBase.getAllStudents(), p4);

        Predicate<Student> p5 = (Student student) -> student.getActivities().contains("soccer");

        filterStudents(StudentDataBase.getAllStudents(), p4.and(p5));

    }
}
