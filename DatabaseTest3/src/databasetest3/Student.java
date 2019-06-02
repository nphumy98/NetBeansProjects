/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetest3;

/**
 *
 * @author MY PHU NGUYEN
 */
public class Student {
    public static int studentNumber=0;
    private int StID;
    private String firstName;
    private String lastName;

    public Student(int studentID, String firstName, String lastName) {
        this.StID = studentID;
        if (StID>studentNumber)
        {
            studentNumber= StID;
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        studentNumber++;
        this.setStudentID(studentNumber);
    }
    
    
    
    @Override
    public String toString() {
        return "Student{" + "studentID=" + StID + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    //get and set method
    public int getStudentID() {
        return StID;
    }

    public void setStudentID(int studentID) {
        this.StID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static int getStudentNumber() {
        return studentNumber;
    }

    public static void setStudentNumber(int studentNumber) {
        Student.studentNumber = studentNumber;
    }
    
    
    
    
}
