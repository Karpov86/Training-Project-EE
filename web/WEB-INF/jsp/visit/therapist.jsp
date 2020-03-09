<%@ page import="by.karpov.entity.Doctor" %>
<%@ page import="by.karpov.entity.Specialty" %>
<%@ page import="by.karpov.service.VisitServiceImpl" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.03.20
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>therapist</title>
</head>
<body>
<h2 style="color: forestgreen">Choose the date</h2>
<p>
<form>
    <input list="dates" type="text" name="date" placeholder="Choose date"/>
</form>
<datalist id="dates">
    <%
        List<LocalDate> freeDates = new VisitServiceImpl().getFreeDates(new Doctor.Builder().setSpecialty(Specialty.THERAPIST).build());
        for (LocalDate date : freeDates) {
            StringBuilder result = new StringBuilder();
            result.append("<option value=" + "\"" + date + "\"" + "/>");
            out.println(result);
        }
    %>
</datalist>
<input name="specialty" type="text" value="THERAPIST" size="20"/>
</p>
<p>
<form action="http://localhost:8080/visit">
    <button>Back</button>
</form>
</p>
</body>
</html>
