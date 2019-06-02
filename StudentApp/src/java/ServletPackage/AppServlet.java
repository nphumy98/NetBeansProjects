/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import ModelPackage.MyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservicepackage.Exception_Exception;
import webservicepackage.StudentWebService_Service;


/**
 *
 * @author MY PHU NGUYEN
 */
public class AppServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StudentServer/StudentWebService.wsdl")
    private StudentWebService_Service service;

    public static String message="hehe";
    public final String PAGE_NAME = "Student login";
    public final String PAGE_TITLE = "Student login";
    private final String NO_TARGET_INDICATOR = "[NO TARGET]";
    
    String userName;
    String password;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        @Override
    public void init()
    {
        try{  
            //1) Create and start connection  
            InitialContext ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
            //2) create Queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            //3) get the Queue object  
            Queue t=(Queue)ctx.lookup("myQueue");  
            //4)create QueueReceiver  
            QueueReceiver receiver=ses.createReceiver(t);  
              
            //5) create listener object  
            MyListener listener=new MyListener();  
              
            //6) register the listener object with receiver  
            receiver.setMessageListener(listener);  
              
            System.out.println("Receiver1 is ready, waiting for messages...");  
            System.out.println("press Ctrl+c to shutdown...");
        }catch(Exception e){System.out.println(e);}
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+this.PAGE_NAME+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+this.PAGE_TITLE+"</h1>");
            out.println("<form action='http://localhost:8080/StudentApp/AppServlet' method = 'Post'>");
            out.println("User ID:  <input type='text' name='UserID'>");
            out.println("User Password:  <input type='password' name='Password'>");
            out.println("<input type='submit' name='login' value='Login here'>");
            out.println("</form>");
            out.println("<h1>Servlet AppServlet at " + this.message + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        
        System.out.println(message);
        this.userName = request.getParameter("UserID").toString();
        this.password = request.getParameter("Password").toString();
//     
//        try {
//            this.sentMessageToAnnounce(1, "TEST Annount 2without target", "BODY Message");
//            this.sentMessageToAnnounceWithTarget(2, "1", "TEST Annount 2 with target", "Message body");
//            this.sentMessageToAnnounceWithTarget(3, "3", "TEST Annount 3 target not hit", "Message body");
//        } catch (Exception_Exception ex) {
//            Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }

        
        
        boolean pass = false;
        try {
            pass = this.checkPassword(Integer.parseInt(userName), password);
        } catch (Exception_Exception ex) {
            Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(pass){
             try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+this.PAGE_TITLE+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+this.PAGE_NAME+"</h1>");
            out.println("<h1>Welcome back "+this.userName+"</h1>");
            out.println("<h1>Announcement</h1>");
            
            try {
            ArrayList<String> result = (ArrayList<String>) this.getAnnounce();
            for(String e : result){
                ArrayList<String> temp = (ArrayList<String>) this.announceDecode(e);
                if(temp.get(1).equals(this.NO_TARGET_INDICATOR)||temp.get(1).equals(this.userName))
                {
                    out.println("<h2>"+temp.get(2)+"</h2>");
                    out.println("<p>"+temp.get(3)+"</p>");
                }
            }
            
        } catch (Exception_Exception ex) {
            Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            out.println("</body>");
            out.println("</html>");
             }
        }else{
        try (PrintWriter out = response.getWriter()) {
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+this.PAGE_TITLE+"</title>");          
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+this.PAGE_NAME+"</h1>");
            out.println("<h1>Your password or user name is wrong</h1>");
            out.println("</body>");
            out.println("</html>");
        }            
    }
        
      //  processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean checkPassword(int arg0, java.lang.String arg1) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.checkPassword(arg0, arg1);
    }

    private void sentMessageToAnnounce(int arg0, java.lang.String arg1, java.lang.String arg2) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        port.sentMessageToAnnounce(arg0, arg1, arg2);
    }

    private java.util.List<java.lang.String> getAnnounce() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.getAnnounce();
    }

    private void sentMessageToAnnounceWithTarget(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        port.sentMessageToAnnounceWithTarget(arg0, arg1, arg2, arg3);
    }

    private java.util.List<java.lang.String> announceDecode(java.lang.String arg0) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.announceDecode(arg0);
    }



}
