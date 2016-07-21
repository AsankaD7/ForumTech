<%-- 
    Document   : askQuestion
    Created on : Jul 14, 2016, 11:23:52 AM
    Author     : Asanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="questionBox/chosen.jquery.js" type="text/javascript"></script>
        <script src="questionBox/inputBoxPostQuestion.js" type="text/javascript"></script>
        <link href="questionBox/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            $(function () {
                $('.chosen-select').chosen();
                $('.chosen-select-deselect').chosen({allow_single_deselect: true});
            });
        </script>   
        <style>
            .question-body-view{
                padding: 5px;
                background-color: white;
                border-radius: 5px;
                border: 1px solid gainsboro;
            }

            .code-desc{
                border: 1px solid #cccccc;
                background-color: #f5f5f5;
                border-radius: 5px;
                resize: none;
                overflow: hidden;
                min-height: 25px;
                /*max-height: 100px;*/
                width: 100%;
            }

            .desc{
                border: 0px;border-radius: 5px;
                resize: none;
                overflow: hidden;
                min-height: 25px;
                /*max-height: 100px;*/
                width: 100%;
            }
            .code-high{
                /*border: 1px solid #f7e1b5;*/
                /*background-color: #fff8dc;*/
                resize: none;
                overflow: hidden;
                min-height: 25px;
                /*max-height: 100px;*/
                width: 100%;
                border-left: 10px solid #f7e1b5;
                font-size: 20px;
                color: sandybrown;
            }
            .code-high:hover{
                border: 1px solid #f7e1b5;
                border-left: 10px solid #f7e1b5;
            }
            .code-high:focus{
                border: 1px solid #f7e1b5;
                border-left: 10px solid #f7e1b5;
            }

            #questionname{
                border: 0px;
                font-size: 20px;
                font-weight: bold;
                border-bottom: 1px solid gainsboro;
                padding: 5px;
            }

            .bottompost{
                display: none;
            }

            .showbottom{
                display: block;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <div id="answer-box" class="question-body-view">
                        <input id="questionname" class="form-control" placeholder="Ask Question"><br/>
                        <textarea placeholder="What's on your mind?" id="inputdesc0" class="form-control desc" onkeyup="auto_grow(this)"></textarea><br/>
                        <div id="display"></div> 

                        <select id="category-select" data-placeholder="Select your Answer Category" multiple class="form-control chosen-select" tabindex="8">
                            <c:forEach items="${category}" var="result">
                                <option value="${result.name}">${result.name}</option>
                            </c:forEach>
                        </select>

                        <div id='bottomp' class='bottompost'>
                            <div style="margin-bottom: 5px;"></div>
                            <input class='btn btn-sm btn-default' id="description" type="submit" value="DESCRIPTION" />
                            <input class='btn btn-sm btn-default' id="code" type="submit" value="CODE INPUT" />
                            <input class='btn btn-sm btn-default' id="high" type="submit" value="HIGHLIGHT BOX" />

                            <input class='btn btn-sm btn-primary' style="float: right" id="donebtn" type="submit" value="POST" />
                        </div>
                    </div>
                </div>
                <div class="col-md-6" id="res">

                </div>
            </div>
        </div>        
    </body>
</html>
