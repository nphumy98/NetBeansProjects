<%-- 
    Document   : studentList
    Created on : 12/03/2019, 2:36:31 AM
    Author     : MY PHU NGUYEN
--%>


<%@page import="StudentDB.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <% ArrayList<Student> studentList= (ArrayList<Student>)request.getAttribute("STUDENT_LIST");%>
    <body>
        <h2>LIST STUDENTS</h2>
        <div>
            <table>
                <tr>
                    <th>Student ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                
                <% for (Student aStudent: studentList) {%>
                <tr>
                    <td> <%= aStudent.getStudentID()%> </td>
                    <td> <%= aStudent.getFirstName() %> </td>
                    <td> <%= aStudent.getLastName() %> </td>
                </tr>
                <%}%>
        
            </table>
        </div>
        
        <hr>
        
        <h2>AVAILABLE</h2>
        <form action="addStudent.jsp">
            <button type="submit">ADD A STUDENT</button>
        </form>
        <br></br>
        <form>
            <!--hidden input field to help Servlet controller work-->
            <input type="hidden" name="userDemand" value="viewStudent" />
            <select name="studentID">
                <% for (Student aStudent: studentList) {%>
                    <option> <%= aStudent.getStudentID()%> </option>
                <%}%>
            </select>
            <button type="submit">SELECT ID TO VIEW</button>
        </form>
    </body>
</html>
