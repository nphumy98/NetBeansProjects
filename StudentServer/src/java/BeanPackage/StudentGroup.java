/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import java.util.ArrayList;

/**
 *
 * @author MY PHU NGUYEN
 */
public class StudentGroup {
    private ArrayList<Student> studentList;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public StudentGroup()
    {
        studentList= new ArrayList<Student>();
    }
    
    public StudentGroup(ArrayList<Student> studentList)
    {
        this.studentList= studentList;
    }
    
    public Student makeStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        return aStudent;
    }
    
    public int addStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        studentList.add(aStudent);
        return studentList.size();
    }
    
}
