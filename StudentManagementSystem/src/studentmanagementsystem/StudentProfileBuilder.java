/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class StudentProfileBuilder {
    private String name;
    private int age;
    private String department;
    private String courseType;

    public StudentProfileBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentProfileBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentProfileBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public StudentProfileBuilder setCourseType(String courseType) {
        this.courseType = courseType;
        return this;
    }

    public StudentProfile build() {
        return new StudentProfile(name, age, department, courseType);
    }
}

class StudentProfile {
    private final String name;
    private final int age;
    private final String department;
    private final String courseType;

    public StudentProfile(String name, int age, String department, String courseType) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.courseType = courseType;
    }

    public void displayProfile() {
        System.out.println("Student Profile: ");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Course Type: " + courseType);
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getDepartment() {
        return department;
    }

    String getCourseType() {
        return courseType;
    }
}


