<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.20
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save patient</title>
    <style>
        .form-save {
            margin-left: 10%;
            padding: 10px;
        }

        .button1 {
            width: 80px;
            background-color: white;
            color: black;
            border: 2px solid #e7e7e7;
        }

        .button1:hover {
            background-color: #e7e7e7;
        }

    </style>
</head>
<body>
<c:import url="blocks/header.jsp"/>
<form class="form-save" action="${pageContext.request.contextPath}save" method="post">
    <p><input autofocus name="name" type="text" placeholder="Enter name" size="20"/></p>
    <p><input autofocus name="surname" type="text" placeholder="Enter surname" size="20"/></p>
    <p><input autofocus name="address" type="text" placeholder="Enter address" size="20"/></p>
    <p><input list="genderList" type="text" name="sex" placeholder="Choose your gender"/></p>
    <p>
        <button class="button1" type="submit" value="save">Submit</button>
        <button class="button1" style="margin-left: 10px" type="reset">Reset</button>
    </p>
</form>
<datalist id="genderList">
    <option value="MALE"/>
    <option value="FEMALE"/>
    <option value="FTM"/>
    <option value="MTF"/>
    <option value="NEUTROIS"/>
    <option value="ANDROGYNE"/>
</datalist>
<c:import url="blocks/footer.jsp"/>
</body>
</html>
