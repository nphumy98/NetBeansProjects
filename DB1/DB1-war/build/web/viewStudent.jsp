<%-- 
    Document   : viewStudent
    Created on : 12/03/2019, 2:54:30 AM
    Author     : MY PHU NGUYEN
--%>

<%@page import="StudentDB.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Student</title>
    </head>
    <% Student retrieveStudent= (Student)request.getAttribute("retrieveStudent");%>
    <body>
        <h1>Student's Information</h1>
        <div>
            <table>
                <tr>
                    <th>Student ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
               
                <tr>
                    <td> <%= retrieveStudent.getStudentID()%> </td>
                    <td> <%= retrieveStudent.getFirstName() %> </td>
                    <td> <%= retrieveStudent.getLastName() %> </td>
                </tr>
            </table>
        </div>
        
        <p><a href="http://localhost:8080/DB1-war/SessionTest?userDemand=startDB">Back to Student List</a></p>
    </body>
</html>
