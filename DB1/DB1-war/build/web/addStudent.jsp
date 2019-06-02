<%-- 
    Document   : addStudent
    Created on : 12/03/2019, 2:54:18 AM
    Author     : MY PHU NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <h1>ADD A STUDENT</h1>
        <form action="http://localhost:8080/DB1-war/SessionTest">
            <!--hidden input field to help Servlet controller work-->
            <input type="hidden" name="userDemand" value="addStudent" />
            
             <p>First name:
                <input type="text" name="firstName"></p>
            <p>Last name:
                <input type="text" name="lastName"></p>
            <button type="submit">ADD A STUDENT</button>
        </form>
        
        <p><a href="http://localhost:8080/DB1-war/SessionTest?userDemand=startDB">Back to Student List</a></p>
    </body>
</html>
