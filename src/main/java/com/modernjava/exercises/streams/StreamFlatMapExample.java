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
//                .peek(student -> {
//                    System.out.println("peek1 :" +student);
//                })
                .flatMap(List::stream) // Stream<String>
//                .peek(student -> {
//                    System.out.println("peek2 Mapping each activity in each list :" +student);
//                })
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return studentActivities;
    }

    public static Set<String> printStudentActivitiesSet(){
        Set<String> studentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .peek(activitiesList -> {
                    System.out.println("peek1 Mapping each list :" +activitiesList);
                })
                .flatMap(List::stream) // Stream<String>
                .peek(activity -> {
                    System.out.println("peek2 Mapping each activity in each list :" +activity);
                })
                .collect(Collectors.toSet());
        return studentActivities;
    }

    public static long getStudentActivitiesCount(){
        long numberOfStudentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .distinct() // Stream<String> with distinct function performed
                .count();
        return numberOfStudentActivities;
    }



    public static void main(String[] args) {
        // goal - print all activities within the lists
        System.out.println("activities List: " + printStudentActivities());
//        System.out.println("activities Set :" + printStudentActivitiesSet());
        System.out.println("number of activities: " + getStudentActivitiesCount());
    }
}
