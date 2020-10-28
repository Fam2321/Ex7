<%-- 
    Document   : output
    Created on : Oct 28, 2020, 3:25:44 PM
    Author     : 60050257
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>calculate Page</title>
    </head>
    <body>
        <h1>
            <%
                String result = (String) request.getAttribute("result");
                String operator = (String) request.getAttribute("operator");
                String message = "the Result of " + request.getParameter("Number1") + operator + request.getParameter("Number2") + " is : " + result;
                out.println(message);
            %>
        </h1>
    </body>
</html>
