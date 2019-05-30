/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentDB;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author MY PHU NGUYEN
 */
@Local
public interface StudentBeanLocal {

    public ArrayList<Student> getStudentList();

    public void addStudent(Student aStudent)throws ClassNotFoundException, SQLException ;

    public Student retrieveStudentInformation(int studentID) throws ClassNotFoundException, SQLException;
    
}
