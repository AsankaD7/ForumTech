<%-- 
    Document   : User
    Created on : Jun 21, 2016, 11:17:21 PM
    Author     : Asanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="addUser" method="POST">
                
            <input type="text" name="userId" type="hidden"/><br/>
            <input type="text" name="name"/><br/>
            <input type="text" name="password"/><br/>
            <input type="text" name="email"/><br/>
            <input type="submit" value="submit"/><br/>
            </form>
        </div>
    </body>
</html>
