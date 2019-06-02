/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MY PHU NGUYEN
 */
public class MyServlet extends HttpServlet {

    Random rd= new Random();
    private int correctNumber= rd.nextInt(98)+1;

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
       //count the session number
       int sessionCounter= processSessionCounter(request);
       //set content type
        response.setContentType("text/html");
        //get the printWriter
        PrintWriter out= response.getWriter();
        //get the number that player has entered
        int numberEntered= Integer.parseInt(request.getParameter("guessNumber"));
        
        //generate HTML content
        out.println("<html><body>");
        out.println("<h1>Session number: "+String.valueOf(sessionCounter)+"</h1>");
        out.println("You have enter "+ request.getParameter("guessNumber"));
//        out.println("The correct number is:"+ String.valueOf(correctNumber));
        if (numberEntered>correctNumber)
        {
            out.println("<h1>Your guess too high. Please guess again</h1>");
            out.println("<a href=\"http://localhost:8080/GuessNumberServlet2/\">Back to Guess</a>");
        }
        else if (numberEntered<correctNumber)
        {
            out.println("<h1>Your guess too small. Please guess again</h1>");
            out.println("<a href=\"http://localhost:8080/GuessNumberServlet2/\">Back to Guess</a>");
        }
        else
        {
            out.println("<h1>Your guess is correct</h1>");
            resetCorrectNumber(); //reset the game
            out.println("<a href=\"http://localhost:8080/GuessNumberServlet2/\">Start a new game</a>");
        }
        out.println("</body></html>");
        out.close();
        
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
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
       private Integer processSessionCounter(HttpServletRequest request)
   {
       // obtain the session for the client that made the request
      HttpSession session = request.getSession(true); //create if none
      //get attribute sessionCounter from session
      Integer sessionCounter = (Integer)session.getAttribute("sessionCounter");
      //if sessionCounter attribute not exist, it mean this is first time client visit
      if (sessionCounter == null)
      {  // new client session
         sessionCounter = new Integer(0); //set sessionCounter to 0
      }
      else
      {  // request is from an existing client session
         sessionCounter = new Integer(sessionCounter.intValue()+1);
      }
      //set back sessionCounter attribute of session to variable in java servlet
      session.setAttribute("sessionCounter", sessionCounter);
      return sessionCounter;
   }
       
       private void redirectToHTML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
       {
           //get requestDispatcher
           RequestDispatcher dispatcher= request.getRequestDispatcher("/index.html");
           //forward the request 
           dispatcher.forward(request, response);
       }
       
       private void resetCorrectNumber()
       {
           this.correctNumber= rd.nextInt(98)+1;
       }

}
