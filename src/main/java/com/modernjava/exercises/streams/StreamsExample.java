package com.modernjava.exercises.streams;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;

public class StreamsExample {
    public static void main(String[] args) {
        // student name and activities on a map, filtered by grade and gpa
        Predicate<Student> studentPredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> studentGpaPredicate = student -> student.getGpa() >= 3.9;

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .filter(studentPredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("student Map: " +studentMap);
    }
}
