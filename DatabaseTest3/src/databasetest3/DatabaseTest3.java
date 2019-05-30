/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetest3;

import java.sql.SQLException;

/**
 *
 * @author MY PHU NGUYEN
 */
public class DatabaseTest3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        StudentBean aStudentBean= new StudentBean();
        System.out.println(aStudentBean.getStudentList().size());
        System.out.println(aStudentBean.getStudentList().get(0).studentNumber);
        aStudentBean.retrieveStudentInformation(6);
        aStudentBean.removeStudent(aStudentBean.getStudentList().get(0));
        System.out.println(aStudentBean.getStudentList().size());
        System.out.println(aStudentBean.getStudentList().get(0).studentNumber);
        aStudentBean.addStudent(new Student("Test1","Test2"));
        System.out.println(aStudentBean.getStudentList().size());
        System.out.println(aStudentBean.getStudentList().get(0).studentNumber);
    }
    
}
