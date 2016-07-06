<%-- 
    Document   : User
    Created on : Jun 21, 2016, 11:17:21 PM
    Author     : Asanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <div class="navbar navbar-default">
            <div class="container-fluid">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">TechForum</a>

                <div class="collapse navbar-collapse" id="mainNavBar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Help<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">asdfg</a></li>
                                <li><a href="#">asdfg</a></li>
                                <li><a href="#">asdfg</a></li>
                            </ul>
                        </li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">SignUp</a></li>
                        <li><a href="#">LogIn</a></li>
                    </ul>
                </div>
            </div>        
        </div>
        <div class="container" >
            <div class="well" id="log">
                <div id="imgDiv">
                    <img src="image1/user_account_profile_avatar_person_student_male-512.png" class="img-circle center-block" alt="..." id="imgPro"/> 
                </div>
                <div id="formDiv">
                    <form action="addLogIn" method="POST">      
                        <label for="selectbasic">User Name</label>
                        <input name="username" type="text"  class="form-control text-f" style="border-radius: 0px" placeholder="Name ?"/><br/>
                        <label for="selectbasic">Password</label>
                        <input name="password" type="password" class="form-control text-f" style="border-radius: 0px" placeholder="Password ?" /><br/>
                        <input id="logBtn" type="submit" class="btn btn-primary center-block" value="Login">
                    </form>
                </div>

            </div>
        </div>

    </body>
</html>
