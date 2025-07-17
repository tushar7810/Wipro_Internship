package com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;

public class StudentService {

    // Method to find grades for an array of students
    public char[] findGrades(Student[] students) {
        if (students == null) {
            System.err.println("Error: Student array itself is null. Cannot process grades.");
            return new char[0]; // Return an empty array if the input array is null
        }

        char[] grades = new char[students.length];

        for (int i = 0; i < students.length; i++) {
            try {
                // Check for NullStudentException
                if (students[i] == null) {
                    throw new NullStudentException("Student object is null at index " + i);
                }

                if (students[i].getName() == null) {
                    throw new NullNameException("Student name is null at index " + i);
                }

                if (students[i].getMarks() == null) {
                    throw new NullMarksArrayException("Marks array is null for student at index " + i);
                }

                int[] marks = students[i].getMarks();
                int sumOfMarks = 0;
                boolean failedInSubject = false;

                int passingMarkPerSubject = 35;

                for (int mark : marks) {
                    if (mark < passingMarkPerSubject) {
                        failedInSubject = true;
                        break; // Fail if any subject mark is below passing
                    }
                    sumOfMarks += mark;
                }

                if (failedInSubject) {
                    grades[i] = 'F';
                } else if (sumOfMarks >= 250) { 
                    grades[i] = 'A';  // A means A+ or AA
                } else if (sumOfMarks < 250) { 
                    grades[i] = 'a';
                } else if (sumOfMarks < 200) { 
                    grades[i] = 'b';
                } else if (sumOfMarks < 150) { 
                    grades[i] = 'c';
                } else if (sumOfMarks < 100) { 
                    grades[i] = 'd';
                } else { // Total marks below 35% or sum < 105
                    grades[i] = 'F';
                }
                students[i].setGrade(grades[i]); // Update the student object's grade

            } catch (NullStudentException e) {
                System.err.println("Error for student at index " + i + ": " + e.getMessage());
                grades[i] = 'F'; // Assign 'F' grade for data errors
                if (students[i] != null) students[i].setGrade('F');
            } catch (NullNameException e) {
                System.err.println("Error for student at index " + i + ": " + e.getMessage());
                grades[i] = 'F'; // Assign 'F' grade for data errors
                if (students[i] != null) students[i].setGrade('F');
            } catch (NullMarksArrayException e) {
                System.err.println("Error for student at index " + i + ": " + e.getMessage());
                grades[i] = 'F'; // Assign 'F' grade for data errors
                if (students[i] != null) students[i].setGrade('F');
            } catch (Exception e) { // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred for student at index " + i + ": " + e.getMessage());
                grades[i] = 'F';
                if (students[i] != null) students[i].setGrade('F');
            }
        }
        return grades;
    }

    // Method to count students with null marks array
    public int findNumberOfNullMarks(Student[] students) {
        if (students == null) return 0; // No students, no null marks arrays
        int count = 0;
        for (Student student : students) {
            if (student != null && student.getMarks() == null) {
                count++;
            }
        }
        return count;
    }

    // Method to count students with null names
    public int findNumberOfNullNames(Student[] students) {
        if (students == null) return 0;
        int count = 0;
        for (Student student : students) {
            if (student != null && student.getName() == null) {
                count++;
            }
        }
        return count;
    }

    // Method to count null student objects
    public int findNumberOfNullObjects(Student[] students) {
        if (students == null) return 0;
        int count = 0;
        for (Student student : students) {
            if (student == null) {
                count++;
            }
        }
        return count;
    }
}
