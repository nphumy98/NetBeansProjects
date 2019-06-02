<%-- 
    Document   : index
    Created on : 1/06/2019, 5:55:50 PM
    Author     : MY PHU NGUYEN
--%>

<%@page import="ModelPackage.MyListener"%>
<%@page import="javax.jms.MessageListener"%>
<%@page import="javax.jms.Session"%>
<%@page import="javax.jms.QueueReceiver"%>
<%@page import="javax.jms.Queue"%>
<%@page import="javax.jms.QueueSession"%>
<%@page import="javax.jms.QueueConnection"%>
<%@page import="javax.jms.QueueConnectionFactory"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Student App</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Welcome to the Admin system</h1>
        <form action='http://localhost:8080/StudentApp/AppServlet'>
            <input type="submit" value = 'click here to login'>
        </form>
    </body>
</html>