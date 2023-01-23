package com.modernjava.exercises.streams;

import com.modernjava.exercises.data.Student;
import com.modernjava.exercises.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int numberOfNoteBooks(){
        int numberOfNBooks = StudentDataBase.getAllStudents().stream()  // -> Stream<Student>
                .filter((student -> student.getGradeLevel() >= 3))
                .filter((student -> student.getGender().equals("female")))
                .map(Student::getNoteBooks)  // -> Stream<Integer>
                .reduce(0, Integer::sum);
        return numberOfNBooks;
    }


    public static void main(String[] args) {
        System.out.println("numberOfNoteBooks :" +numberOfNoteBooks());
    }
}
