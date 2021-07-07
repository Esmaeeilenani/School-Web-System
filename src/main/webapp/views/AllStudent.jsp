
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
        <title>Student List Page</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <h1 class="page-header">Student List</h1>
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
                            ClassRoom
                        </th>
                        <th>
                            Action
                        </th>
                    </tr>
                </thead>

                <tbody >

                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.getName()}</td>
                            <td>${student.getEmail()}</td>
                            <td>${student.getDob()}</td>
                            <td>${student.getRoom().getClassName()}</td>
                            <td><a href="/ManageStudents/StudentForm?id=${student.id}" class="edit">Edit</a>  <a class="delete" href="/ManageStudents/Delete?id=${student.id}">Delete</a> </td>


                        </tr>


                    </c:forEach>

                </tbody>
            </table>


        </main>
    </body>
</html>
