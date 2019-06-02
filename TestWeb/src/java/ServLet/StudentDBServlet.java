/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServLet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try
        {
            studentBean= new StudentBean();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            getStudentListDB(request, response);
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

}
