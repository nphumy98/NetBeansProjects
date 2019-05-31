/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicePackage;

import BeanPackage.Gender;
import BeanPackage.Student;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author MY PHU NGUYEN
 */
@WebService(serviceName = "testWebService")
public class testWebService {

    /**
     * This is a sample web service operation
     */
        private ArrayList<Student> studentList;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @WebMethod(operationName = "initList")
    public int initList()
    {
        this.studentList = new ArrayList<Student>();
        return this.studentList.size();
    }
    
     @WebMethod(operationName = "makeStudent")
    public Student makeStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        return aStudent;
    }
    
     @WebMethod(operationName = "addStudent")
    public int addStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        studentList.add(aStudent);
        return studentList.size();
    }
}
