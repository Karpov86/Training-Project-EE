<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sacred Heart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        .header2{
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
<c:import url="WEB-INF/jsp/blocks/header.jsp"/>
<h1 style="margin-left: 40%">Home page</h1>
<h2 class="header2"><a href="${pageContext.request.contextPath}save">Register</a> on our website and sign in. If you are already registered, then <a
        href="${pageContext.request.contextPath}login">sign in</a>.</h2>
<c:import url="WEB-INF/jsp/blocks/footer.jsp"/>
</body>
</html>