/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class StudentManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
//          // Singleton Pattern
//        CourseRegistrationSystem regSystem = CourseRegistrationSystem.getInstance();
//        regSystem.registerCourse("Maryam", "selected");
//
//        GradeProcessingSystem gradeSystem = GradeProcessingSystem.getInstance();
//        gradeSystem.calculateGrade("Maryam", 85);
//
//        // Factory Pattern
//        Course coreCourse = CourseFactory.createCourse("lab");
//        coreCourse.displayDetails();
//
//        Student gradStudent = StudentFactory.createStudent("graduate");
//        gradStudent.displayDetails();
//
//        // Builder Pattern
//        StudentProfile profile = new StudentProfileBuilder()
//                .setName("Maryam")
//                .setAge(20)
//                .setDepartment("Engineering")
//                .setCourseType("lab")
//                .build();
//        profile.displayProfile();
//
//        // Proxy Pattern
//        Timetable proxyTimetable = new ProxyTimetable();
//        proxyTimetable.displayTimetable();
//
//        // Adapter Pattern
//        GradeCalculator adapter = new ExternalGradeAdapter();
//        adapter.calculateGrade(45);
//        

     javax.swing.SwingUtilities.invokeLater(() -> {
            new StudentManagementGUI().setVisible(true);
        });

        
    }
    
}
