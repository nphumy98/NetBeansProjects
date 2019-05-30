/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentServlet;

import StudentDB.Student;
import StudentDB.StudentBean;
import StudentDB.StudentBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MY PHU NGUYEN
 */
public class StudentDBServlet extends HttpServlet {
    @EJB
    private StudentBeanLocal studentBean;   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userDemand= request.getParameter("userDemand");
            if (userDemand=="null")
            {
                userDemand= "startDB";
            }
            
            switch(userDemand)
            {
                case "startDB":
//                    this.init();
                    getStudentListDB(request, response);
                    break;
                case "addStudent":
                    getAddStudent(request,response);
                    break;
                case "viewStudent":
                    viewStudent(request,response);
                    break;
                default:
                    getStudentListDB(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    private void getStudentListDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get StudentList from DB
        ArrayList<Student> studentList= studentBean.getStudentList();
        //add StudentList to request
        request.setAttribute("STUDENT_LIST", studentList);
        //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/studentList.jsp");
        dispatcher.forward(request, response);
    }

    private void getAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        //get parameter from user input
        String firstName= request.getParameter("firstName");
        String lastName= request.getParameter("lastName");
        //create new student object
        Student aStudent= new Student(firstName, lastName);
        //add student to database
        studentBean.addStudent(aStudent);
        //back to main page studentList.jsp (from method getStudentLIstDB)
        getStudentListDB(request, response);
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        //get parameter from user input
        int studentID= Integer.parseInt(request.getParameter("studentID"));
        //get Student from database
        Student retrieveStudent= studentBean.retrieveStudentInformation(studentID);
         //add retrieve Student to request
        request.setAttribute("retrieveStudent", retrieveStudent);
        //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/viewStudent.jsp");
        dispatcher.forward(request, response);
    }

}
