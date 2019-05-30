/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicePackage;

import BeanPackage.Student;
import BeanPackage.StudentBean;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author MY PHU NGUYEN
 */
@WebService(serviceName = "StudentBeanWebService")
@Stateless()
public class StudentBeanWebService {
    @EJB
    private StudentBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createStudent")
    public Student createStudent(@WebParam(name = "name") String name) {
        return ejbRef.createStudent(name);
    }

    @WebMethod(operationName = "plusStudent")
    public int plusStudent(@WebParam(name = "name") String name) {
        return ejbRef.plusStudent(name);
    }

    @WebMethod(operationName = "getStudentList")
    public ArrayList<Student> getStudentList() {
        return ejbRef.getStudentList();
    }

    @WebMethod(operationName = "setStudentList")
    @Oneway
    public void setStudentList(@WebParam(name = "studentList") ArrayList<Student> studentList) {
        ejbRef.setStudentList(studentList);
    }
    
}
