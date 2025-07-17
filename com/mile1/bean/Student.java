package com.mile1.bean;

public class Student {
    private String name;
    private int[] marks;
    private char grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.grade = ' '; 
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    public char getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder marksStr = new StringBuilder("[");
        if (marks != null) {
            for (int i = 0; i < marks.length; i++) {
                marksStr.append(marks[i]);
                if (i < marks.length - 1) {
                    marksStr.append(", ");
                }
            }
        } else {
            marksStr.append("null");
        }
        marksStr.append("]");

        return "Student [Name=" + (name != null ? name : "null") + ", Marks=" + marksStr.toString() + ", Grade=" + grade + "]";
    }
}
