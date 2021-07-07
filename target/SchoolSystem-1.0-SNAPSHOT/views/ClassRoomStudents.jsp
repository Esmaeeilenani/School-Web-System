
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
        <title>ClassRoom Student List Page</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <h1 class="page-header">ClassRoom All Student List</h1>
        
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
                            Student Id
                        </th>
                        <th>
                            Student Name
                        </th>

                    </tr>

                </thead>

                <tbody >

                    <c:forEach items="${students}" var="student">

                        <tr>
                            <td>
                                ${student.id}
                            </td>
                            <td>
                                ${student.getName()}
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </main>
    </body>
</html>
