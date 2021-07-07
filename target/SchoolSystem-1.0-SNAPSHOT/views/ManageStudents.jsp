<%-- 
    Document   : ManageStudents
    Created on : Jul 2, 2021, 2:24:53 AM
    Author     : esmaeeil-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="/resources/css/main.css" type="text/css" />
        <title>Manage Students</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <main class="container">
            <div class="alert alert-error ${show}">
                ${errormsg}
            </div>
            <div class="col2-grid showcase">


                <a href="/ManageStudents/StudentForm" class = "card action-box-right">
                    <div class="content-box">
                        <i class="fas fa-user-plus fa-4x"></i>
                        <br/>
                        <br/>
                        Add Student
                    </div>
                </a>

                <a href="/ManageStudents/displaystudent" class = "card action-box-left">
                    <div class="content-box">
                        <i class="fas fa-list  fa-4x"></i>
                        <br>
                        <br>
                        Students List
                    </div>
                </a>

                <div class="content-box card midle-icon">
                    <i class="fas fa-user-graduate fa-5x"></i>
                    <br>                        
                    <br>
                    Students Management                        
                </div>

                <a href="/ManageStudents/StudentSubjects" class = "card action-box-right">
                    <div class="content-box">
                        <i class="fas fa-book fa-4x"></i>
                        <br>
                        <br>
                        Student Subjects
                    </div>
                </a>


            </div>
        </main>
    </body>
</html>
