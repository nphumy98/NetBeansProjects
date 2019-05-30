/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservice.Customer;
import webservice.CustomerWebService_Service;
import webservice.TestBeanService;



/**
 *
 * @author MY PHU NGUYEN
 */
public class NewServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CustomerWebService/CustomerWebService.wsdl")
    private CustomerWebService_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebApplication3/testBeanService.wsdl")
    private TestBeanService service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
//            Customer aCustomer= createCustomer("Minh");
//            Customer aCustomer2= createCustomer("Duc");
            
            plusCustomer("Minh");
           int size= plusCustomer("Duc");
           
           ArrayList<Customer> customerList= (ArrayList<Customer>) getCustomerList();
           
            //int size1= addCustomer(aCustomer);
            //String size= Integer.toString(size1);
            //int size2=addCustomer(aCustomer2);
            /* TODO output your page here. You may use following sample code. */
            String result= sayHello("Jimmy");
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + size + "</h1>");
            out.println("<p><a href=\"index.jsp\">Return to Home Page</a></p>");
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
        processRequest(request, response);
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

    private String sayHello(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TestBean port = service.getTestBeanPort();
        return port.sayHello(arg0);
    }

    private int addCustomer(webservice.Customer aCustomer) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.addCustomer(aCustomer);
    }

    private Customer createCustomer(java.lang.String name) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.createCustomer(name);
    }

    private java.util.List<webservice.Customer> getCustomerList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.getCustomerList();
    }

    private int plusCustomer(java.lang.String name) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.CustomerWebService port = service_1.getCustomerWebServicePort();
        return port.plusCustomer(name);
    }

    

    

}
