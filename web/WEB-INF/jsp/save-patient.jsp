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
</head>
<body>
<form action="${pageContext.request.contextPath}/patient/save" method="post">
    <p><input name="name" type="text" placeholder="Enter name" size="20"/></p>
    <p><input name="surname" type="text" placeholder="Enter surname" size="20"/></p>
    <p><input name="address" type="text" placeholder="Enter address" size="20"/></p>
    <p><input list="genderList" type="text" name="sex" placeholder="Choose your gender"/></p>
    <p>
        <button type="submit" value="save">Save</button>
        <button type="reset">Reset</button>
    </p>
</form>
<form action="http://localhost:8080/">
    <button>To homepage</button>
</form>
<datalist id="genderList">
    <option value="MALE"/>
    <option value="FEMALE"/>
    <option value="FTM"/>
    <option value="MTF"/>
    <option value="NEUTROIS"/>
    <option value="ANDROGYNE"/>
</datalist>

</body>
</html>
