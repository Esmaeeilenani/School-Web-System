<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="/resources/css/main.css" type="text/css" />
        <title>Home</title>
    </head>
    <body>
        <%@include file="header.html" %>

        <main class="container">
            <div class="col2-grid showcase">

                <a href="ManageStudents" class = "card">
                    <div class="content-box">
                        <i class="fas fa-user-graduate fa-4x"></i>
                        <br>
                        <br>
                        Manage Students
                    </div>
                </a>
                <a href="ManageTeachers"class = "card">
                    <div class="content-box">
                        <i class="fas fa-chalkboard-teacher fa-4x"></i>
                        <br/>
                        <br/>
                        Manage Teachers
                    </div>
                </a>

                <a href="/ManageClass" class = "card">
                    <div class="content-box">
                        <i class="fas fa-chalkboard fa-4x"></i>
                        <br>
                        <br>
                        Manage Classes
                    </div>
                </a>

                <a href="/ManageSubjects" class = "card">
                    <div class="content-box">
                        <i class="fab fa-accusoft fa-4x"></i>
                        <br>
                        <br>
                        Manage Subjects
                    </div>
                </a>
            </div>
        </main>
    </body>
</html>
