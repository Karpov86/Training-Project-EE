<%@ page import="by.karpov.entity.Doctor" %>
<%@ page import="by.karpov.service.DoctorServiceImpl" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.20
  Time: 13:37
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
<h2 align="center">Our doctors</h2>

<table>
    <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Specialty</th>
    </tr>
    <%
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        List<Doctor> doctors = doctorService.findAll();
        for (Doctor doctor : doctors) {
            StringBuilder result = new StringBuilder();
            result.append("<tr>")
                    .append("<td>" + doctor.getName() + " " + doctor.getSurname() + "</td>")
                    .append("<td>" + doctor.getSex() + "</td>")
                    .append("<td>" + doctor.getSpecialty() + "</td>")
                    .append("</tr>");
            out.println(result);
        }
    %>
</table>
<p>
<form action="http://localhost:8080/">
    <button>To homepage</button>
</form>
</p>
</body>
</html>
