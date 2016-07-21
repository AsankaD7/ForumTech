<%-- 
    Document   : User
    Created on : Jun 21, 2016, 11:17:21 PM
    Author     : Asanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="../FRONT/topFront.jsp"></jsp:include>
        <div class="container" >
            <div class="well" id="log">
                <div id="imgDiv">
                    <img src="${path}" class="img-circle center-block" alt="..." id="imgPro"/> 
                </div>
                <div id="formDiv">
                    <form:form action="addLogIn" method="POST" modelAttribute="user">      
                        <label for="selectbasic">User Name</label>
                        <form:input name="username" path="email" type="text"  class="form-control text-f" style="border-radius: 0px" placeholder="Email ?"/><br/>
                        <label for="selectbasic">Password</label>
                        <form:password name="passwform:inputord" path="password" class="form-control text-f" style="border-radius: 0px" placeholder="Password ?" /><br/>
                        <input id="logBtn" type="submit" class="btn btn-primary center-block" value="Login">
                    </form:form>
                </div>
            </div><br/>
            <div class="well" id="info">
                    Don't have an account?<a href="SignUp"> Sign up</a>
            </div>
        </div>

    </body>
</html>
