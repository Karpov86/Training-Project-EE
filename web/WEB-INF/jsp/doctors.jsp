<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.03.20
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctors</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<c:import url="blocks/header.jsp"/>
<h2 align="center">Our doctors</h2>

<div>
    <table>
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Specialty</th>
        </tr>

        <c:forEach var="doctor" items="${doctors}">
            <tr>
                <td>${doctor.name} ${doctor.surname}</td>
                <td>${doctor.sex}</td>
                <td>${doctor.specialty}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<c:import url="blocks/footer.jsp"/>
</body>
</html>
