<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Therapist</title>
</head>
<body>
<c:import url="blocks/header.jsp"/>
<h2 style="margin-left: 10%">Choose the date</h2>
<div style="margin-left: 10%">

    <form class="form-save" action="${pageContext.request.contextPath}/visit/therapist" method="post">
        <label>
            <input list="dates" type="text" name="date" placeholder="Choose date"/>
        </label>
        <label>
            <input name="specialty" type="text" value="THERAPIST" size="20"/>
        </label>
        <p>
            <button type="submit" value="save">Submit</button>
        </p>

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

</div>
<c:import url="blocks/footer.jsp"/>
</body>
</html>
