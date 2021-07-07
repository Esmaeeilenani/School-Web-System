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
        <title>Subject Form</title>
    </head>
    <body>
        <%@include file="header.html" %>    

        <main class = "showcase container">
            <div class="card info">



                <h3 class="card-header">Subject Info</h3>
                <div class="alert alert-error ${show}">
                    ${errormsg}
                </div>


                <form:form action="/ManageSubjects/Add" cssClass="form" method="POST" modelAttribute="subject">

                    <c:if test="${subject.id ne 0}">                        
                        <div class="form-input" >
                            <form:label path="id">Subject ID</form:label>
                            <form:input disabled="true" path="id" value = "${subject.id}" type ="text"  ></form:input>                                                                                                         
                            <form:hidden path="id" value = "${subject.id}" ></form:hidden>
                            </div>                            
                    </c:if>

                    <div class="form-input">
                        <form:label path="name">Subject Name</form:label>
                        <form:input value = "${subject.getName()}" path = "name" type ="text" placeholder="Subject Name"></form:input>
                        
                        </div>
                    <form:button>Save</form:button>

                </form:form>


            </div>






        </main>

    </body>
</html>
