/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class CourseFactory {
   
    public static Course createCourse(String type) {
        switch (type.toLowerCase()) {
            case "core":
                return new CoreCourse();
            case "elective":
                return new ElectiveCourse();
            case "lab":
                return new LabCourse();
            default:
                throw new IllegalArgumentException("Invalid course type");
        }
    }
}


class CoreCourse implements Course {
    @Override
    public void displayDetails() {
        System.out.println("Core Course");
    }
}

class ElectiveCourse implements Course {
    @Override
    public void displayDetails() {
        System.out.println("Elective Course");
    }
}

class LabCourse implements Course {
    @Override
    public void displayDetails() {
        System.out.println("Lab Course");
    }
}

