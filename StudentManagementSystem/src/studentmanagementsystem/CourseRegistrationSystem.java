/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class CourseRegistrationSystem {
 
    private static CourseRegistrationSystem instance;
    
    private CourseRegistrationSystem() {
        // Private constructor
    }
    
    public static  CourseRegistrationSystem getInstance() {
        if (instance == null) {
            instance = new CourseRegistrationSystem();
        }
        return instance;
    }
    
    public void registerCourse(String studentName, String courseName) {
        System.out.println(studentName + " has registered for " + courseName);
    }
}


