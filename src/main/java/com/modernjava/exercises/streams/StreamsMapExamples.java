package com.modernjava.exercises.streams;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExamples {

    public static List<String> namesList(){
        return StudentDataBase.getAllStudents().stream() // outputs Stream<Student>
                // gets Student as input >> outputs Student Name
                .map(Student::getName) // outputs Stream<String>
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Set<String> namesSet(){
        return StudentDataBase.getAllStudents().stream() // outputs Stream<Student>
                // gets Student as input >> outputs Student Name
                .map(Student::getName) // outputs Stream<String>
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println(namesList());
        System.out.println(namesSet());
    }
}
