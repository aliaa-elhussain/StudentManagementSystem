/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class StudentFactory {
    public static Student createStudent(String type) {
        switch (type.toLowerCase()) {
            case "undergraduate":
                return new UndergraduateStudent();
            case "graduate":
                return new GraduateStudent();
            case "part-time":
                return new PartTimeStudent();
            default:
                throw new IllegalArgumentException("Invalid student type");
        }
    }
}



class UndergraduateStudent implements Student {
    @Override
    public void displayDetails() {
        System.out.println("Undergraduate Student");
    }
}

class GraduateStudent implements Student {
    @Override
    public void displayDetails() {
        System.out.println("Graduate Student");
    }
}

class PartTimeStudent implements Student {
    @Override
    public void displayDetails() {
        System.out.println("Part-Time Student");
    }
}


