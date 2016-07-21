<%-- 
    Document   : editProfile
    Created on : Jul 10, 2016, 7:54:01 PM
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
        <jsp:include page="../OTHER/top.jsp"></jsp:include>
       
        <form action="upload" method="POST" enctype="multipart/form-data">
            <input type="file" name="file" />
            <br/>
            <br/>
            <input type="submit" value="Upload" />
        </form>
        
        <h1>Welcome ${username}</h1>
        
        <img width="300px" src="${path}"/>
        
        <jsp:include page="../OTHER/bottom.jsp"></jsp:include>
        
    </body>
</html>
