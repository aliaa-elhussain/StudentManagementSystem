/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 */
public class ProxyTimetable implements Timetable {
     private RealTimetable realTimetable;

    @Override
    public void displayTimetable() {
        if (realTimetable == null) {
            realTimetable = new RealTimetable();
        }
        System.out.println("Accessing timetable through proxy...");
        realTimetable.displayTimetable();
    }
    
}
