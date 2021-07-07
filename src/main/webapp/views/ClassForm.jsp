<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <title>ClassRoom Form</title>
    </head>
    <body>
        <%@include file="header.html" %>    

        <main class = "showcase container">
            <div class="card info">



                <h3 class="card-header">ClassRoom Info</h3>
                <div class="alert alert-error ${show}">
                    ${errormsg}
                </div>


                <form:form action="/ManageClass/Add" cssClass="form" method="POST" modelAttribute="classroom">

                    <c:if test="${classroom.id ne 0}">                        
                        <div class="form-input" >
                            <form:label path="id">ClassRoom ID</form:label>
                            <form:input disabled="true" path="id" value = "${classroom.id}" type ="text"  ></form:input>                                                                                                         
                            <form:hidden path="id" value = "${classroom.id}" ></form:hidden>
                            </div>                            
                    </c:if>

                    <div class="form-input">
                        <form:label path="className">ClassRoom Name</form:label>
                        <form:input value = "${classroom.getClassName()}" path = "className" type ="text" placeholder="ClassRoom Name"></form:input>
                        </div>
                    <form:button>Save</form:button>

                </form:form>


            </div>






        </main>

    </body>
</html>
