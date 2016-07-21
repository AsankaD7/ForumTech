<%-- 
    Document   : top
    Created on : Jul 14, 2016, 9:03:15 AM
    Author     : Asanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .img-pro{
                width: 15px;
                border-radius: 100%;
            }
        </style> 
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
                        <li class="active"><a href="questionWall">Home</a></li>
                        <li><a href="askQuestion">Ask Question</a></li>
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
                        <li><a href="loadEditProfile"><img class="img-pro" src="${path}" alt=""/> ${username}</a></li>
                    </ul>
                </div>
            </div>        
        </div>

    </body>
</html>
