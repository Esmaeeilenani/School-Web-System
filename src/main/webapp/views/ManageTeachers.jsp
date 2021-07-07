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
        <title>Manage Teachers</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <main class="container">
            <div class="col2-grid showcase">


                <a href="/ManageTeachers/TeacherForm" class = "card action-box-right">
                    <div class="content-box">
                        <i class="fas fa-user-plus fa-4x"></i>
                        <br/>
                        <br/>
                        Add Teacher
                    </div>
                </a>

                <a href="/ManageTeachers/DisplayTeachers" class = "card action-box-left">
                    <div class="content-box">
                        <i class="fas fa-list  fa-4x"></i>
                        <br>
                        <br>
                        Teachers List
                    </div>
                </a>

                <div class="content-box card midle-icon">
                    <i class="fas fa-chalkboard-teacher fa-5x"></i>
                    <br>                        
                    <br>
                    Teachers Management                        
                </div>

                <a href="/ManageTeachers/TeacherSubjects" class = "card action-box-right">
                    <div class="content-box">
                        <i class="fas fa-book fa-4x"></i>
                        <br>
                        <br>
                        Teacher Subjects
                    </div>
                </a>

                <a href="/ManageTeachers/AddSubjectTeacher" class = "card action-box-left">
                    <div class="content-box">
                        <i class="fas fa-user-edit fa-4x"></i>
                        <br>
                        <br>
                        Assign Teacher to Subject
                    </div>
                </a>
            </div>
        </main>
    </body>
</html>
