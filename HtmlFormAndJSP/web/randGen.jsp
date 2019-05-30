<%-- 
    Document   : randGen
    Created on : 10/03/2019, 1:24:09 PM
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
        GENERATE ${param.generateAmount} RANDOM NUMBER WITHIN RANGE 1 TO ${param.rangeRandom}
        <hr></hr>
        <%
            for (int i=1;i<=Integer.parseInt(request.getParameter("generateAmount"));i++)
            {
                int range= Integer.parseInt(request.getParameter("rangeRandom"));
                double randomNumber=Math.random()*range+1;
                int rdNumber= (int)randomNumber;
                out.println(i+ ": The generated number is "+rdNumber+"<br>");
            }
            
           
            
         %>
    </body>
</html>
