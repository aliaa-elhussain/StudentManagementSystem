/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Abdel
 * 
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Student class
class Student {
    private String name;
    private int age;
    private String department;
    private String courseName;
    private String courseType;
    private String studentType;
    private int grade = -1; // درجة الطالب، -1 تعني أنها غير معروفة بعد

    // Constructor to initialize student
    public Student(String name, int age, String department, String courseName, String courseType, String studentType) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.courseName = courseName;
        this.courseType = courseType;
        this.studentType = studentType;
    }

    // Methods to set and get grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getGradeStatus() {
        if (grade == -1) return "Grade not set yet.";
        return grade >= 60 ? "Passed" : "Failed";
    }

    public String getStudentType() {
        return studentType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nDepartment: " + department + "\nCourse Name: " + courseName +
               "\nCourse Type: " + courseType + "\nStudent Type: " + studentType + "\nGrade: " + (grade == -1 ? "Not set" : grade);
    }
}

// Main GUI class
public class StudentManagementGUI extends JFrame {
    private CardLayout cardLayout; // To switch between screens
    private JPanel mainPanel; // Main panel to hold all screens

    private List<Student> students = new ArrayList<>(); // List to store student data
    private Map<String, String> timetable = new HashMap<>(); // Map to store course and its time

    public StudentManagementGUI() {
        setTitle("Student Management System");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adding different screens
        mainPanel.add(createLoginScreen(), "LoginScreen");
        mainPanel.add(createAdminScreen(), "AdminScreen");
        mainPanel.add(createStudentScreen(), "StudentScreen");

        add(mainPanel);
        cardLayout.show(mainPanel, "LoginScreen");
    }

    // Login Screen
    private JPanel createLoginScreen() {
        JPanel loginPanel = new JPanel(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 50, 100, 25);
        loginPanel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 50, 200, 25);
        loginPanel.add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);
        loginPanel.add(passwordField);

        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(100, 200, 100, 30);
        adminButton.addActionListener(e -> {
            // Navigate to Admin Screen
            cardLayout.show(mainPanel, "AdminScreen");
        });
        loginPanel.add(adminButton);

        JButton studentButton = new JButton("Student");
        studentButton.setBounds(250, 200, 100, 30);
        studentButton.addActionListener(e -> {
            // Navigate to Student Screen
            cardLayout.show(mainPanel, "StudentScreen");
        });
        loginPanel.add(studentButton);

        return loginPanel;
    }

    // Admin Screen
    private JPanel createAdminScreen() {
        JPanel adminPanel = new JPanel(null);

        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameLabel.setBounds(50, 50, 100, 25);
        adminPanel.add(studentNameLabel);

        JTextField studentNameField = new JTextField();
        studentNameField.setBounds(150, 50, 200, 25);
        adminPanel.add(studentNameField);

        JLabel studentAgeLabel = new JLabel("Student Age:");
        studentAgeLabel.setBounds(50, 100, 100, 25);
        adminPanel.add(studentAgeLabel);

        JTextField studentAgeField = new JTextField();
        studentAgeField.setBounds(150, 100, 200, 25);
        adminPanel.add(studentAgeField);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(50, 150, 100, 25);
        adminPanel.add(departmentLabel);

        JTextField departmentField = new JTextField();
        departmentField.setBounds(150, 150, 200, 25);
        adminPanel.add(departmentField);

        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(50, 200, 100, 25);
        adminPanel.add(courseNameLabel);

        JTextField courseNameField = new JTextField();
        courseNameField.setBounds(150, 200, 200, 25);
        adminPanel.add(courseNameField);

        JLabel courseTypeLabel = new JLabel("Course Type:");
        courseTypeLabel.setBounds(50, 250, 100, 25);
        adminPanel.add(courseTypeLabel);

        JComboBox<String> courseTypeCombo = new JComboBox<>(new String[]{"Core", "Elective", "Lab"});
        courseTypeCombo.setBounds(150, 250, 200, 25);
        adminPanel.add(courseTypeCombo);

        JLabel studentTypeLabel = new JLabel("Student Type:");
        studentTypeLabel.setBounds(50, 300, 100, 25);
        adminPanel.add(studentTypeLabel);

        JComboBox<String> studentTypeCombo = new JComboBox<>(new String[]{"Undergraduate", "Graduate", "Part-time"});
        studentTypeCombo.setBounds(150, 300, 200, 25);
        adminPanel.add(studentTypeCombo);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 350, 100, 30);
        registerButton.addActionListener(e -> {
            String name = studentNameField.getText();
            String ageText = studentAgeField.getText();
            String department = departmentField.getText();
            String courseName = courseNameField.getText();
            String courseType = (String) courseTypeCombo.getSelectedItem();
            String studentType = (String) studentTypeCombo.getSelectedItem();

            if (name.isEmpty() || ageText.isEmpty() || department.isEmpty() || courseName.isEmpty() || courseType == null || studentType == null) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                Student student = new Student(name, age, department, courseName, courseType, studentType);
                students.add(student); // Add to list

                JOptionPane.showMessageDialog(this, "Student registered successfully:\n" + student);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        adminPanel.add(registerButton);

        JButton processGradeButton = new JButton("Process Grade");
        processGradeButton.setBounds(300, 350, 150, 30);
        processGradeButton.addActionListener(e -> {
            if (students.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No students registered yet.");
                return;
            }

            for (Student student : students) {
                String gradeText = JOptionPane.showInputDialog(this, "Enter grade for " + student.getName() + ":");
                try {
                    int grade = Integer.parseInt(gradeText);
                    student.setGrade(grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid grade for: " + student.getName());
                }
            }

            JOptionPane.showMessageDialog(this, "Grades processed successfully.");
        });
        adminPanel.add(processGradeButton);

        JButton timetableButton = new JButton("Timetable");
        timetableButton.setBounds(150, 400, 100, 30);
        timetableButton.addActionListener(e -> {
            String course = JOptionPane.showInputDialog(this, "Enter Course Name:");
            String time = JOptionPane.showInputDialog(this, "Enter Course Time:");
            if (course != null && time != null && !course.isEmpty() && !time.isEmpty()) {
                timetable.put(course, time);
                JOptionPane.showMessageDialog(this, "Timetable updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
            }
        });
        adminPanel.add(timetableButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "LoginScreen"));
        adminPanel.add(backButton);

        return adminPanel;
    }

    // Student Screen
    private JPanel createStudentScreen() {
        JPanel studentPanel = new JPanel(null);

        JButton viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(150, 50, 150, 30);
        viewProfileButton.addActionListener(e -> {
            if (students.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No students registered yet.");
                return;
            }

            // Assuming a single student view for simplicity, you can extend for multiple
            Student student = students.get(0); // Retrieve the first student (just for demonstration)
            StringBuilder profile = new StringBuilder();
            profile.append("Student Name: ").append(student.getName()).append("\n")
                    .append("Age: ").append(student.getAge()).append("\n")
                    .append("Department: ").append(student.getDepartment()).append("\n")
                    .append("Course: ").append(student.getCourseName()).append("\n")
                    .append("Course Type: ").append(student.getCourseType()).append("\n")
                    .append("Student Type: ").append(student.getStudentType()).append("\n");

            JOptionPane.showMessageDialog(this, profile.toString(), "Student Profile", JOptionPane.INFORMATION_MESSAGE);
        });
        studentPanel.add(viewProfileButton);

        JButton viewGradeButton = new JButton("View Grade");
        viewGradeButton.setBounds(150, 100, 150, 30);
        viewGradeButton.addActionListener(e -> {
            if (students.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No students registered yet.");
                return;
            }

            // Assuming a single student view for simplicity, you can extend for multiple
            Student student = students.get(0); // Retrieve the first student
            String gradeInfo = "Grade: " + (student.getGrade() == -1 ? "Not set" : student.getGrade()) + "\n"
                    + "Status: " + student.getGradeStatus();

            JOptionPane.showMessageDialog(this, gradeInfo, "Grade Result", JOptionPane.INFORMATION_MESSAGE);
        });
        studentPanel.add(viewGradeButton);

        JButton viewTimetableButton = new JButton("View Timetable");
        viewTimetableButton.setBounds(150, 150, 150, 30);
        viewTimetableButton.addActionListener(e -> {
            if (students.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No students registered yet.");
                return;
            }

            // Assuming a single student view for simplicity, you can extend for multiple
            Student student = students.get(0); // Retrieve the first student
            String courseTime = timetable.get(student.getCourseName());

            JOptionPane.showMessageDialog(this, "Course Time: " + (courseTime != null ? courseTime : "Not available"), "Timetable", JOptionPane.INFORMATION_MESSAGE);
        });
        studentPanel.add(viewTimetableButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "LoginScreen"));
        studentPanel.add(backButton);

        return studentPanel;
    }

    
}

