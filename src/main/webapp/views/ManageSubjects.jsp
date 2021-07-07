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
        <title>Manage Subjects</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <main class="container">
            <div class="row showcase">


                <a href="/ManageSubjects/SubjectForm" class = "card">
                    <div class="content-box">
                        <i class="fas fa-plus-square fa-4x"></i>

                        Add Subject
                    </div>
                </a>

                <a href="/ManageSubjects/AllSubjects" class = "card ">
                    <div class="content-box">
                        <i class="fas fa-list  fa-4x"></i>
                        Subject List
                    </div>
                </a>
                
            </div>
        </main>
    </body>
</html>
