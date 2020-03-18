<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        .btn-group .button {
            background-color: #e3e3e3; /* Green */
            color: #000000;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            width: 150px;
            display: block;
        }

        .btn-group .button:not(:last-child) {
            border-bottom: none; /* Prevent double borders */
        }

        .btn-group .button:hover {
            background-color: #636363;
        }
    </style>
</head>
<body>
<c:import url="blocks/header.jsp"/>
<h2 style="margin-left: 15%">Choose the specialist</h2>

<div style="margin-left: 10%" class="btn-group">
    <p align="center">
    <form action="/visit/therapist">
        <button class="button">THERAPIST</button>
    </form>
    <form action="/visit/surgeon">
        <button class="button">SURGEON</button>
    </form>
    <form action="/visit/cardiologist">
        <button class="button">CARDIOLOGIST</button>
    </form>
    <form action="/visit/gynecologist">
        <button class="button">GYNECOLOGIST</button>
    </form>
    </p>
</div>
<c:import url="blocks/footer.jsp"/>
</body>
</html>
