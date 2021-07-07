
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
        <title>Teacher List Page</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <h1 class="page-header">Teacher List</h1>
        <main class = "showcase container">


            <table class="card">
                <thead>
                    <tr>
                        <th>
                            Id
                        </th>
                        <th>
                            Name
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            BirthDate
                        </th>
                        <th>
                            JoiningDate
                        </th>
                        <th>
                            Action
                        </th>
                    </tr>
                </thead>

                <tbody >

                    <c:forEach items="${teachers}" var="teacher">
                        <tr>
                            <td>${teacher.id}</td>
                            <td>${teacher.getName()}</td>
                            <td>${teacher.getEmail()}</td>
                            <td>${teacher.getDob()}</td>
                            <td>${teacher.getJoiningDate()}</td>
                            <td><a href="/ManageTeachers/TeacherForm?id=${teacher.id}" class="edit">Edit</a>  <a class="delete" href="/ManageTeachers/Delete?id=${teacher.id}">Delete</a> </td>


                        </tr>
                    </c:forEach>

                </tbody>
            </table>


        </main>
    </body>
</html>
