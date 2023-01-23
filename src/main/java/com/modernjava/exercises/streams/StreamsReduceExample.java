package com.modernjava.exercises.streams;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample {
    public static int performMultiplication(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a * b);
    }

    public static Optional<Student> getStudentWithHighestGPA(){
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 3, 5, 7);
        List<Integer> integers2 = new ArrayList<>();

//        System.out.println(performMultiplication(integers));
//        System.out.println(performMultiplicationWithoutIdentity(integers).isPresent());
//        System.out.println(performMultiplicationWithoutIdentity(integers).get());

        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
        Optional<Integer> result2 = performMultiplicationWithoutIdentity(integers2);

//        if(result.isPresent()) {
//            System.out.println(result.get());
//        }
        // same as below:

        result.ifPresent(System.out::println); // this gets printed

        result2.ifPresent(System.out::println); // this doesn't

        Optional<Student> studentOptional = getStudentWithHighestGPA();
        if(getStudentWithHighestGPA().isPresent()) {
            System.out.println(getStudentWithHighestGPA().get());
        }

    }
}
