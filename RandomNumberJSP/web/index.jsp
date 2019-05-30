<%-- 
    Document   : index
    Created on : 10/03/2019, 1:00:22 PM
    Author     : MY PHU NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>GENERATE A RANDOM NUMBER WITH JSP!</h1>
        <%
            double randomNumber=Math.random()*100;
            int rdNumber= (int)randomNumber;
            out.println("The generated number is "+rdNumber);
         %>
    </body>
</html>
