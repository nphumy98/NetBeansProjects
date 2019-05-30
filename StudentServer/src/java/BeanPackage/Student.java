/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import javax.naming.InitialContext;


/**
 *
 * @author MY PHU NGUYEN
 */

public class Student {
    private static int studentNumber=0;
    private int studentID;
    private String studentName;
    private int age;
    private Gender gender;
    
    public Student(int studentID, String studentName, int age, Gender gender)
    {
        this.studentID= studentID;
        if (studentID>studentNumber)
        {
            studentNumber= studentID;
        }
        this.studentName= studentName;
        this.age=age;
        this.gender=gender;
    }
    
    public Student (String studentName, int age, Gender gender)
    {
        this.studentName= studentName;
        this.age=age;
        this.gender=gender;
        studentNumber++;
        this.studentID=studentNumber;
    }
    
    //getter and setter
    public static int getStudentNumber() {
        return studentNumber;
    }

    public static void setStudentNumber(int studentNumber) {
        Student.studentNumber = studentNumber;
    }
    
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
