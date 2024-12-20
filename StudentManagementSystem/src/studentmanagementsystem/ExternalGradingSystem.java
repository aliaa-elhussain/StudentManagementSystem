/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class ExternalGradingSystem {
    
    public void processGrades(int score) {
        String result = score >= 50 ? "Pass" : "Fail";
        System.out.println("External Grading System: " + result);
    }
    
}
