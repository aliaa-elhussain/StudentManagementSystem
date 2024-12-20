/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class GradeProcessingSystem {
   
    private static GradeProcessingSystem instance;
    
    private GradeProcessingSystem() {
        // Private constructor
    }
    
    public static  GradeProcessingSystem getInstance() {
        if (instance == null) {
            instance = new GradeProcessingSystem();
        }
        return instance;
    }
    
     public String calculateGrade(String studentName, int marks) {
        String grade;
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "B";
        } else if (marks >= 70) {
            grade = "C";
        } else if (marks >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    public boolean isPass(int marks) {
        return marks >= 60; // Pass if marks are 60 or above
    }

    
//    public void calculateGrade(String studentName, int marks) {
//        String grade = marks >= 50 ? "Pass" : "Fail";
//        System.out.println(studentName + " has been graded: " + grade);
//    }
}


