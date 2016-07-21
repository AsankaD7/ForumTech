<%-- 
    Document   : signUp
    Created on : Jul 7, 2016, 1:14:57 PM
    Author     : Asanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../FRONT/topFront.jsp"></jsp:include>
            <div class="container">
                <div id="heading">
                    <h1>CREATE YOUR FORUM TECH ACCOUNT</h1>
                </div><br/>
                <div class="well" id="signUp">
                    <div id="signUpDiv">
                    <form:form action="addSignUp" method="POST" modelAttribute="user">
                        <div class="col-md-6">   
                            <label for="selectbasic">First Name</label>
                            <form:input name="firstname" path="firstName" type="text"  class="form-control text-f" style="border-radius: 0px" placeholder="Name ?"/>
                        </div>
                        <div class="col-md-6">
                            <label for="selectbasic">Last Name</label>
                            <form:input name="lastname" path="lastName" type="text"  class="form-control text-f" style="border-radius: 0px" placeholder="Name ?"/>                           
                        </div>   
                        <div class="col-md-12">
                            <br/>
                            <label for="selectbasic">Enter Your Email Address</label>
                            <form:input name="email" path="email" type="text" class="form-control text-f" style="border-radius: 0px" placeholder="email ?" /><br/>                
                            <label for="selectbasic">Create a password</label>
                            <form:password name="password" path="password"  class="form-control text-f" style="border-radius: 0px" placeholder="Password ?" /><br/>
                            <label for="selectbasic">Confirm your password</label>
                            <input name="confirmPassword" type="password" class="form-control text-f" style="border-radius: 0px" placeholder="Password ?" /><br/>
                            <label for="selectbasic">Mobile phone</label>
                            <form:input name="mobile" path="mobile" type="text" class="form-control text-f" style="border-radius: 0px" placeholder="mobile ?" /><br/>                        
                            <input id="signupBtn" type="submit" class="btn btn-primary pull-right" value="SignUp">
                        </div>
                    </form:form>
                </div>                
            </div>
        </div>
    </body>
</html>
