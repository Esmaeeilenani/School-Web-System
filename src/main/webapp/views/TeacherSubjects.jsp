
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
        <title>Teacher Subjects Page</title>
    </head>
    <body>
        <%@include file="header.html" %>
        <h1 class="page-header">Teacher Subjects</h1>
        <main class = "showcase container">

            <div class="alert alert-error ${show}">
                ${errormsg}
            </div>


            <form class="form">
                <div class="form-input">
                    <label>Teacher Id</label>
                    <input value = "${TeaID}" type="text" placeholder="Enter Teacher Id" name="TeaID" >
                </div>                    
                <div class="form-input">
                    <label>Teacher name</label>
                    <input value = "${name}" type="text" name="name" disabled="true" >
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
                            Class Room
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
                                ${subject.getRoomsNames()}
                            </td>

                        </tr>

                    </c:forEach>

                </tbody>
            </table>


        </main>
    </body>
</html>
