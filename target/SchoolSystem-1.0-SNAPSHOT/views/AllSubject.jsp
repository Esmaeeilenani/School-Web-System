
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="/resources/css/main.css" type="text/css" />
        <title>Subject List Page</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <h1 class="page-header">Subject List</h1>
        <main class = "showcase container">
            <div class="alert alert-error ${show}">
                ${errormsg}
            </div>

            <table class="card">
                <thead>
                    <tr>
                        <th>
                            Subject Id
                        </th>
                        <th>
                            Subject Name
                        </th>

                        <th>
                            Subject Teacher
                        </th>
                        <th>
                            Subject Classes
                        </th>
                    </tr>
                </thead>

                <tbody >

                    <c:forEach items="${subjects}" var="subjects">
                        <tr>
                            <td>${subjects.id}</td>
                            <td>${subjects.getName()}</td>                            
                            <td>${subjects.getTeacherName()}</td>                            
                            <td>${subjects.getClassRoomsNames()}</td>                            

                        </tr>
                    </c:forEach>

                </tbody>
            </table>


        </main>
    </body>
</html>
