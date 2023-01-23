package com.modernjava.exercises.streams;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static List<String> printStudentActivities(){
        List<String> studentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .collect(Collectors.toList());
        return studentActivities;
    }

    public static Set<String> printStudentActivitiesSet(){
        Set<String> studentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .collect(Collectors.toSet());
        return studentActivities;
    }


    public static void main(String[] args) {
        // goal - print all activities within the lists
        System.out.println("activities List: " + printStudentActivities());;
        System.out.println("activities Set :" + printStudentActivitiesSet());;
    }
}
