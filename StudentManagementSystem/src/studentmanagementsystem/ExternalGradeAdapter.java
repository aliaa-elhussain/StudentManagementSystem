/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class ExternalGradeAdapter implements GradeCalculator {

    private final ExternalGradingSystem externalGradingSystem;

    public ExternalGradeAdapter() {
        this.externalGradingSystem = new ExternalGradingSystem();
    }

    @Override
    public void calculateGrade(int marks) {
        externalGradingSystem.processGrades(marks);
    }

}