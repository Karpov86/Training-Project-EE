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
<form action="/visit/therapist">
    <button>THERAPIST</button>
</form>
<form action="/visit/surgeon">
    <button>SURGEON</button>
</form>
<form action="/visit/cardiologist">
    <button>CARDIOLOGIST</button>
</form>
<form action="/visit/gynecologist">
    <button>GYNECOLOGIST</button>
</form>

<form action="http://localhost:8080/">
    <button>To homepage</button>
</form>
</p>
</body>
</html>
