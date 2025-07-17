package com.mile1.main;

import com.mile1.bean.Student;
import com.mile1.service.StudentService;

import java.util.Arrays;

public class StudentMain {

    public static void main(String[] args) {
        Student[] students = new Student[8];

        // Valid students
        students[0] = new Student("Alice", new int[]{70, 80, 90}); // Total 240 -> A
        students[1] = new Student("Bob", new int[]{60, 65, 70});   // Total 195 -> B
        students[2] = new Student("Charlie", new int[]{40, 45, 50}); // Total 135 -> C
        students[3] = new Student("David", new int[]{35, 35, 35}); // Total 105 -> D
        students[4] = new Student("Eve", new int[]{30, 80, 90});   // One mark < 35 -> F

        // Students with data errors
        students[5] = null;                                       // Null Student Object
        students[6] = new Student("Frank", null);                 // Null Marks Array
        students[7] = new Student(null, new int[]{70, 80, 90});   // Null Name

        StudentService studentService = new StudentService();

        System.out.println("--- Processing Student Grades ---");
        char[] grades = studentService.findGrades(students);

        System.out.println("\n--- Grades and Student Details ---");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println("Student " + (i + 1) + ": " + students[i] + " (Calculated Grade: " + grades[i] + ")");
            } else {
                System.out.println("Student " + (i + 1) + ": Null Student Object (Calculated Grade: " + grades[i] + ")");
            }
        }

        System.out.println("\n--- Error Counts ---");
        System.out.println("Number of Null Student Objects: " + studentService.findNumberOfNullObjects(students));
        System.out.println("Number of Students with Null Marks Array: " + studentService.findNumberOfNullMarks(students));
        System.out.println("Number of Students with Null Names: " + studentService.findNumberOfNullNames(students));

        // Test with a completely null array
        System.out.println("\n--- Testing with a completely null student array ---");
        Student[] nullStudentsArray = null;
        char[] gradesFromNullArray = studentService.findGrades(nullStudentsArray);
        System.out.println("Grades from null array: " + Arrays.toString(gradesFromNullArray));
        System.out.println("Number of Null Student Objects (from null array): " + studentService.findNumberOfNullObjects(nullStudentsArray));
    }
}
