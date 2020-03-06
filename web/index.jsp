<%@ page import="by.karpov.dao.DoctorDaoImpl" %>
<%@ page import="by.karpov.entity.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test JSP</title>
    <style>
        body {
            background-color: #e3e3e3
        }

        h1 {
            color: forestgreen;
            text-align: center
        }

        p {
            color: crimson;
            font-family: Calibri;
            font-style: italic
        }
    </style>
</head>
<body>
<h1>Test JSP</h1>
<p>
    <% DoctorDaoImpl doctorDao = DoctorDaoImpl.newInstance();
        List<Doctor> doctors = doctorDao.getDoctors();
        for (Doctor d : doctors) {
            out.println("<p>" + d.getName() + " " + d.getSurname() + ", address: " + d.getAddress() + ", sex: " + d.getSex() + ", specialty: " + d.getSpecialty() + "</p>");
        }
    %>

</p>

</body>
</html>