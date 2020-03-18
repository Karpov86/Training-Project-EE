<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.03.20
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal"><a href="/">Sacred Heart</a></h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}save">Registration</a>
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}getDoctors">Our doctors</a>
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}visit">Appointment with the doctor</a>
        <a class="p-2 text-dark" href="#">Contacts</a>
        <a class="p-2 text-dark" href="#">About</a>
    </nav>
    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}login">Sign up</a>
</div>
</body>
</html>
