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
        <title>Manage Classes</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <main class="container">
            <div class="row showcase">


                <a href="/ManageClass/ClassForm" class = "card">
                    <div class="content-box">
                        <i class="fas fa-plus-square fa-4x"></i>

                        Add ClassRoom
                    </div>
                </a>

                <a href="/ManageClass/AllClasses" class = "card ">
                    <div class="content-box">
                        <i class="fas fa-list  fa-4x"></i>

                        <p>ClassRoom List</p>
                    </div>
                </a>


                <a href="/ManageClass/AllClassSubjects" class = "card ">
                    <div class="content-box">
                        <i class="fas fa-book fa-4x"></i>
                        ClassRoom Subjects
                    </div>
                </a>

                <a href="/ManageClass/AssignSubjects" class = "card ">
                    <div class="content-box">
                        <i class="fas fa-edit fa-4x"></i>

                        Assign Subject to ClassRoom
                    </div>
                </a>
                <a href="/ManageClass/AllStudent" class = "card">
                    <div class="content-box">
                        <i class="fas fa-list-ul fa-4x"></i>                        
                        All Student in ClassRoom
                    </div>
                </a>
            </div>
        </main>
    </body>
</html>
