<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.20
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specialty</title>
</head>
<body>
<h2 style="color: forestgreen">Choose the specialist</h2>
<p align="center">
<form action="${pageContext.request.contextPath}/visit" method="get">
    <button type="submit" name="specialty">THERAPIST</button>
    <button inputmode="specialty">SURGEON</button>
    <button inputmode="specialty">SURGEON</button>
    <button inputmode="specialty">CARDIOLOGIST</button>
    <button type="submit" name="specialty">GYNECOLOGIST</button>
</form>
</p>
</body>
</html>
