
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
        <title>ClassRoom Subject List Page</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <h1 class="page-header">Available Subjects List to be Assigned </h1>
        <main class = "showcase container">
            <div class="alert alert-error ${show}">
                ${errormsg}
            </div>


            <form class="form">
                <div class="form-input">
                    <label>ClassRoom Id</label>
                    <input value = "${ClassId}" type="text" disabled="true"  name="ClassId" >
                </div>                    
                <div class="form-input">
                    <label>ClassRoom name</label>
                    <input value = "${ClassName}" type="text" name="ClassName" placeholder="ClassRoom Name"  >
                </div>                    

                <button type="submit">Find</button>
            </form>


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
                            Assign Subject
                        </th>

                    </tr>

                </thead>

                <tbody >

                    <c:forEach items="${subjects}" var="subject">

                        <tr>
                            <td>
                                ${subject.id}
                            </td>
                            <td>
                                ${subject.getName()}
                            </td>
                            <td>
                                <a href="/ManageClass/AssignSubjects?SubId=${subject.id}&ClassName=${ClassName}" class="edit">Assign</a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </main>
    </body>
</html>
